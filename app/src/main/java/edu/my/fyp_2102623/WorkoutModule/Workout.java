package edu.my.fyp_2102623.WorkoutModule;

public class Workout {
    private String title;
    private String imageName; // Name or path of the image file

    public Workout(String title, String imageName) {
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


