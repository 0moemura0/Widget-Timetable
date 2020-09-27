package com.example.worst_first;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

public class ScheduleWidgetService extends RemoteViewsService {


    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ScheduleWidgetItemFactory(getApplicationContext(), intent);
    }

    private class ScheduleWidgetItemFactory implements RemoteViewsFactory {
        private Context context;
        private int appWidgetId;
        private List<Lesson> lessons = new ArrayList<>();

        public ScheduleWidgetItemFactory(Context applicationContext, Intent intent) {
            this.context = applicationContext;
            this.appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        @Override
        public void onCreate() {
            lessons.add(new Lesson("11:40", "Математика", "Милованович И.И", "1212", Buildings.LOMO, TypesOfLessons.Consultation));
            lessons.add(new Lesson("15:20", "Функциональный анализ", "Додонов Н.Ю", "453", Buildings.KRONVA, TypesOfLessons.LaboratoryWork));
            lessons.add(new Lesson("18:40", "Иностранный язык", "", "", Buildings.DISTANT, TypesOfLessons.Lecture));
            lessons.add(new Lesson("20:00", "Теория вероятностей", "Кривцова И. Е.", "1616", Buildings.KOMSOMOL_D5, TypesOfLessons.Practice));
        }

        @Override
        public void onDataSetChanged() {

        }

        @Override
        public void onDestroy() {
        }

        @Override
        public int getCount() {
            return lessons.size();
        }

        @Override
        public RemoteViews getViewAt(int position) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.schedule_item);
            views.setTextViewText(R.id.time, lessons.get(position).getTime());
            views.setTextViewText(R.id.name, lessons.get(position).getName());
            views.setInt(R.id.time, "setBackgroundColor", getResources().getColor(lessons.get(position).getType()));
            views.setTextViewText(R.id.nameOfLesson, lessons.get(position).getNameOfLesson());


            if (!lessons.get(position).getTeacher().isEmpty())
                views.setTextViewText(R.id.teacher, lessons.get(position).getTeacher());
            else
                views.setViewVisibility(R.id.teacher, View.GONE);

            if (!lessons.get(position).getClassroom().isEmpty() && !lessons.get(position).getBuild().isEmpty())
                views.setTextViewText(R.id.auditory, "каб. " + lessons.get(position).getClassroom() + ", " + lessons.get(position).getBuild());
            else if (!lessons.get(position).getBuild().isEmpty())
                views.setTextViewText(R.id.auditory, lessons.get(position).getBuild());
            else
                views.setViewVisibility(R.id.auditory, View.GONE);
            return views;

        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }
    }
}
