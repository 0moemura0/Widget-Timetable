package com.example.worst_first;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;


public class ScheduleWidgetProvider extends AppWidgetProvider {
    public static final String ACTION_REFRESH = "actionRefresh";

    private String GROUPNAME = "N3349";
    private String DATENAME = "13 сентября";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {

            Intent serviceIntent = new Intent(context, ScheduleWidgetService.class);
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            serviceIntent.setData(Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME)));

            Intent clickIntent = new Intent(context, ScheduleWidgetProvider.class);
            clickIntent.setAction(ACTION_REFRESH);
            PendingIntent clickPendingIntent = PendingIntent.getBroadcast(context,
                    0, clickIntent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.schedule_widget);
            views.setTextViewText(R.id.group, GROUPNAME);
            views.setTextViewText(R.id.date, DATENAME);
            views.setRemoteAdapter(R.id.schedule_list, serviceIntent);
            views.setEmptyView(R.id.schedule_list, R.id.example_widget_empty_view);
            views.setPendingIntentTemplate(R.id.schedule_list, clickPendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.schedule_list);
        }
    }
    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.schedule_widget);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
    }
    @Override
    public void onEnabled(Context context) {

    }
    @Override
    public void onDisabled(Context context) {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_REFRESH.equals(intent.getAction())) {
            int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.schedule_list);
        }
        super.onReceive(context, intent);
    }
}