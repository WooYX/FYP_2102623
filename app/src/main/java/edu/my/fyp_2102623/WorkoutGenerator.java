package edu.my.fyp_2102623;

import java.util.ArrayList;
import java.util.List;

public class WorkoutGenerator {
    public static List<Workout> generateLegWorkouts() {
        List<Workout> legWorkouts = new ArrayList<>();
        legWorkouts.add(new Workout("Squats ", "squats.gif"));
        legWorkouts.add(new Workout("Lunges ", "lunges.gif"));
        legWorkouts.add(new Workout("Bulgarian Split Squats ", "bulgariansplitsquats.gif"));
        legWorkouts.add(new Workout("Glute Bridges ", "glutebridges.gif"));
        legWorkouts.add(new Workout("Wall Sit ", "wallsit.gif"));
        legWorkouts.add(new Workout("Box Jumps ", "boxjumps.gif"));
        legWorkouts.add(new Workout("Step-Ups ", "stepups.gif"));
        legWorkouts.add(new Workout("Plyometric Lunges ", "plyometriclunges.gif"));
        legWorkouts.add(new Workout("Calf Raises ", "calfraises.gif"));
        legWorkouts.add(new Workout("Pistol Squats ", "pistolsquats.gif"));
        return legWorkouts;
    }

    public static List<Workout> generateChestWorkouts() {
        List<Workout> chestWorkouts = new ArrayList<>();
        chestWorkouts.add(new Workout("Push-Ups ", "pushups.gif"));
        chestWorkouts.add(new Workout("Incline Push-Ups ", "inclinepushups.gif"));
        chestWorkouts.add(new Workout("Push-Up Variations ", "pushupvariations.gif"));
        chestWorkouts.add(new Workout("Plyometric Push-Ups ", "plyometricpushups.gif"));
        chestWorkouts.add(new Workout("Dips ", "dips.gif"));
        chestWorkouts.add(new Workout("Decline Push-Ups ", "declinepushups.gif"));
        chestWorkouts.add(new Workout("Chest Squeeze Push-Ups ", "chestsqueezepushups.gif"));
        chestWorkouts.add(new Workout("Clap Push-Ups ", "clappushups.gif"));
        chestWorkouts.add(new Workout("Diamond Push-Ups ", "diamondpushups.gif"));
        chestWorkouts.add(new Workout("Wide Grip Push-Ups ", "widegrippushups.gif"));
        return chestWorkouts;
    }

    public static List<Workout> generateBackWorkouts() {
        List<Workout> backWorkouts = new ArrayList<>();
        backWorkouts.add(new Workout("Pull-Ups ", "pullups.gif"));
        backWorkouts.add(new Workout("Bodyweight Rows ", "bodyweightrows.gif"));
        backWorkouts.add(new Workout("Inverted Rows ", "invertedrows.gif"));
        backWorkouts.add(new Workout("Commando Pull-Ups ", "commandopullups.gif"));
        backWorkouts.add(new Workout("Australian Pull-Ups ", "australianpullups.gif"));
        backWorkouts.add(new Workout("Chin-Ups (Pull-up bar)", "chinups.gif"));
        backWorkouts.add(new Workout("Bodyweight Lat Pulldowns ", "latpulldowns.gif"));
        backWorkouts.add(new Workout("Negative Pull-Ups ", "negativepullups.gif"));
        backWorkouts.add(new Workout("One-Arm Row ", "onearmrow.gif"));
        backWorkouts.add(new Workout("Scapular Pull-Ups ", "scapularpullups.gif"));
        return backWorkouts;
    }

    public static List<Workout> generateArmWorkouts() {
        List<Workout> armWorkouts = new ArrayList<>();
        armWorkouts.add(new Workout("Diamond Push-Ups ", "diamondpushups.gif"));
        armWorkouts.add(new Workout("Tricep Dips ", "tricepdips.gif"));
        armWorkouts.add(new Workout("Close Grip Push-Ups ", "closegrippushups.gif"));
        armWorkouts.add(new Workout("Tricep Bench Dips ", "tricepbenchdips.gif"));
        armWorkouts.add(new Workout("Arm Circles ", "armcircles.gif"));
        armWorkouts.add(new Workout("Incline Push-Ups ", "inclinepushups.gif"));
        armWorkouts.add(new Workout("Chair Dips )", "chairdips.gif"));
        armWorkouts.add(new Workout("Bicep Curls ", "bicepcurls.gif"));
        armWorkouts.add(new Workout("Tricep Extensions ", "tricepextensions.gif"));
        armWorkouts.add(new Workout("Hammer Curls ", "hammercurls.gif"));
        return armWorkouts;
    }

}
