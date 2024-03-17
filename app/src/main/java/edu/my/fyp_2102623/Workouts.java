package edu.my.fyp_2102623;

public class Workouts {
    private String title;
    private String imageName; // Use resource name as a reference

    public Workouts(String title, String imageName) {
        this.title = title;
        this.imageName = imageName;
    }

    public String getTitle() {
        return title;
    }

    public String getImageName() {
        return imageName;
    }
}

