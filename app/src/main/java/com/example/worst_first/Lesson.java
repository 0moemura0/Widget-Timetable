package com.example.worst_first;

public class Lesson {
    private String time;
    private String name;
    private String teacher;
    private String classroom;
    private Buildings build;
    private TypesOfLessons type;

    public Lesson(String time, String name, String teacher, String classroom, Buildings build, TypesOfLessons type) {
        this.time = time;
        this.name = name;
        this.teacher = teacher;
        this.classroom = classroom;
        this.build = build;
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
    public String getNameOfLesson() {
        return type.getNameOfLesson();
    }

    public String getTeacher() {
        return teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getBuild() {
        return build.getAddress();
    }

    public int getType() {
        return type.getTypeOfLesson();
    }

}


