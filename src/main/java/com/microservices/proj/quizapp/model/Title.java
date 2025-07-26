package com.microservices.proj.quizapp.model;

public class Title {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Title(int id, String title) {
        this.id = id;
        this.title = title;
    }

    private int id;

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    private String title;
}
