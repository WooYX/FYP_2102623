package edu.my.fyp_2102623;

import java.util.ArrayList;
import java.util.List;

public class WorkoutGenerator {
    public static List<Workout> generateLegWorkouts() {
        List<Workout> legWorkouts = new ArrayList<>();
        legWorkouts.add(new Workout("Squats ", "squats"));
        legWorkouts.add(new Workout("Lunges ", "lunges"));
        legWorkouts.add(new Workout("Bulgarian Split Squats ", "bulgariansplitsquat"));
        legWorkouts.add(new Workout("Glute Bridges ", "glutebridges"));
        legWorkouts.add(new Workout("Wall Sit ", "wallsit"));
        legWorkouts.add(new Workout("Box Jumps ", "boxjumps"));
        legWorkouts.add(new Workout("Step-Ups ", "stepups"));
        legWorkouts.add(new Workout("Lunges ", "lunges"));
        legWorkouts.add(new Workout("Calf Raises ", "calfraises"));
        legWorkouts.add(new Workout("Pistol Squats ", "pistolsquats"));
        return legWorkouts;
    }

    public static List<Workout> generateChestWorkouts() {
        List<Workout> chestWorkouts = new ArrayList<>();
        chestWorkouts.add(new Workout("Push-Ups ", "pushups"));
        chestWorkouts.add(new Workout("Incline Push-Ups ", "inclinepushups"));
        chestWorkouts.add(new Workout("Push-Up Variations ", "pushupvariations"));
        chestWorkouts.add(new Workout("Push-Ups ", "pushups"));
        chestWorkouts.add(new Workout("Dips ", "dips"));
        chestWorkouts.add(new Workout("Decline Push-Ups ", "declinepushups"));
        chestWorkouts.add(new Workout("Chest Press ", "chestpress"));
        chestWorkouts.add(new Workout("Push-Up Variations ", "pushupvariations"));
        chestWorkouts.add(new Workout("Diamond Push-Ups ", "diamondpushups"));
        chestWorkouts.add(new Workout("Push-Ups ", "pushups"));
        return chestWorkouts;
    }

    public static List<Workout> generateBackWorkouts() {
        List<Workout> backWorkouts = new ArrayList<>();
        backWorkouts.add(new Workout("Pull-Ups ", "pullups"));
        backWorkouts.add(new Workout("Bodyweight Rows ", "bodyweightrows"));
        backWorkouts.add(new Workout("Inverted Rows ", "invertedrows"));
        backWorkouts.add(new Workout("Commando Pull-Ups ", "commandopullups"));
        backWorkouts.add(new Workout("Above Head Stretches ", "aboveheadstretches"));
        backWorkouts.add(new Workout("Chin-Ups (Pull-up bar)", "chinups"));
        backWorkouts.add(new Workout("Bodyweight Lat Pulldowns ", "latpulldowns"));
        backWorkouts.add(new Workout("Negative Pull-Ups ", "negativepullup"));
        backWorkouts.add(new Workout("One-Arm Row ", "onearmrow"));
        backWorkouts.add(new Workout("Scapular Pull-Ups ", "scapularpullups"));
        return backWorkouts;
    }

    public static List<Workout> generateArmWorkouts() {
        List<Workout> armWorkouts = new ArrayList<>();
        armWorkouts.add(new Workout("Diamond Push-Ups ", "diamondpushups"));
        armWorkouts.add(new Workout("Chair Dips ", "dipschair"));
        armWorkouts.add(new Workout("Push-Up Variations ", "pushupvariations"));
        armWorkouts.add(new Workout("Tricep Dips ", "tricepdips"));
        armWorkouts.add(new Workout("Arm Circles ", "armcircles"));
        armWorkouts.add(new Workout("Incline Push-Ups ", "inclinepushups"));
        armWorkouts.add(new Workout("Chair Dips ", "dipschair"));
        armWorkouts.add(new Workout("Bicep Curls ", "bicepcurls"));
        armWorkouts.add(new Workout("Tricep Extensions ", "tricepextensions"));
        armWorkouts.add(new Workout("Hammer Curls ", "hammercurls"));
        return armWorkouts;
    }

}
