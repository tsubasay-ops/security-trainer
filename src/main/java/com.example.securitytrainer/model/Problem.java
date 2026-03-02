package com.example.securitytrainer.model;

public class Problem {

    private Long id;
    private String title;
    private String imagePath;

    public Problem(Long id, String title, String imagePath) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImagePath() {
        return imagePath;
    }
}