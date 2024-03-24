package edu.my.fyp_2102623.Social;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class PostFactory {

    public Post createPost(String author, String id, String title, String description, String date, ArrayList<String> activities, String location, ArrayList<String> followers, int price, int max, int likes, ArrayList<String> liked) {
        return new SingleActivity(author, id, title, description, date, activities.get(0), likes, liked);
    }


    public Post createPostfromDBSnapshot(DocumentSnapshot d) {
        Post p;
        Map<String, Object> map = d.getData();
        if (map == null) return null;
        if (map.keySet().size() == 8) {
            p = new SingleActivity(
                    (String) map.get("author"),
                    (String) map.get("id"),
                    (String) map.get("title"),
                    (String) map.get("description"),
                    (String) map.get("date"),
                    (String) map.get("activity"),
                    ((Long) Objects.requireNonNull(map.get("likes"))).intValue(),
                    (ArrayList<String>) map.get("liked"));
        } else {
            // Handle other cases or return null if needed
            return null;
        }
        return p;
    }

    public Post createPostfromDBQuerySnapshot(QueryDocumentSnapshot d) {
        Post p;
        Map<String, Object> map = d.getData();
        if (map.keySet().size() == 8) {
            p = new SingleActivity(
                    (String) map.get("author"),
                    (String) map.get("id"),
                    (String) map.get("title"),
                    (String) map.get("description"),
                    (String) map.get("date"),
                    (String) map.get("activity"),
                    ((Long) Objects.requireNonNull(map.get("likes"))).intValue(),
                    (ArrayList<String>) map.get("liked"));
        } else {
            // Handle other cases or return null if needed
            return null;
        }
        return p;
    }
}