package com.example.worst_first;

public enum TypesOfLessons {
    Practice(R.color.Practice, "Прак"),
    Lecture(R.color.Lecture, "Лек"),
    LaboratoryWork(R.color.LaboratoryWork, "Лаб"),
    Consultation(R.color.Consultation, "Конс");
    private int color;
    private String name;

    TypesOfLessons(int color, String name) {
        this.color = color;
        this.name = name;
    }

    public int getTypeOfLesson() {
            return color;
    }
    public String getNameOfLesson(){
        return name;
    }
}
