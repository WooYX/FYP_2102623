package edu.my.fyp_2102623.Social;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import edu.my.fyp_2102623.Social.Post;
import edu.my.fyp_2102623.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class RecycleFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<Post> dataset;

    public RecycleFeedAdapter(Context context, List<Post> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    /**
     * turns the type of post into a number where 0 -> indiv. 1 -> sml. 2 -> lrg.
     * return -1 if the post is not any of the defined types of post
     *
     * @param position: the position in the list of the post
     * @return: the type of post as an int (0 -> indiv. 1 -> sml. 2 -> lrg.)
     */
    @Override
    public int getItemViewType(int position) {
        if (dataset.get(position) instanceof SingleActivity) {
            return 0;
        }
        return -1;
    }


    /**
     * Inflates the layout of the Posts that is to say that it gets the right type of
     * xml file for the post.
     *
     * @param parent:   the parent of the view
     * @param viewType: the type of Post that it is (0 -> indiv. 1 -> sml. 2 -> lrg.)
     * @return: the viewHolder that corresponds to the viewType
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new IndividualViewHolder(LayoutInflater.from(context).inflate(R.layout.feed, parent, false));
            default:
                try {
                    throw new Exception("No such type of post defined");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return null;
    }


    /**
     * Used to populate the view holders with the things in the post held in the
     * list
     *
     * @param holder:   The view holder to be populated
     * @param position: the position of the Post in the list that will populate the view
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Populate the Individual Posts
        if (dataset.get(position) instanceof SingleActivity) {
            ((IndividualViewHolder) holder).id = dataset.get(position).getId();
            ((IndividualViewHolder) holder).getAuthor().setText(dataset.get(position).getAuthor());
            ((IndividualViewHolder) holder).getTextViewTitle().setText(dataset.get(position).getTitle());
            ((IndividualViewHolder) holder).getDescription().setText(dataset.get(position).getDescription());
            ((IndividualViewHolder) holder).getDate().setText(dataset.get(position).getDate());
            ((IndividualViewHolder) holder).getActivity().setText(((SingleActivity) dataset.get(position)).getActivity());
        }
    }

    /**
     * Returns the number of items in the Recycle View
     *
     * @return: the number of items in the recycleView
     */

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    /**
     *  Define the View holders for each of the types of posts.
     *  They are how the post itself is displayed (they define the xml file used)
     *  on the recycle view
     */

    /**
     * Defines the viewholder class for the recycler view that coresponds to the Individual posts
     * This is the internal class that makes the xml file link to the adapter
     */
    public class IndividualViewHolder extends RecyclerView.ViewHolder {
        //initialise the elements that will be populated by the adapter
        String id;
        FirebaseFirestore db;
        private final TextView author;
        private final TextView title;
        private final TextView description;
        private final TextView date;
        private final Chip activity;

        //Constructor that gets the elements in the xml file
        public IndividualViewHolder(@NonNull View itemView) {
            super(itemView);
            db = FirebaseFirestore.getInstance();
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            author = itemView.findViewById(R.id.individualAuthorText);
            title = itemView.findViewById(R.id.individualTitleText);
            description = itemView.findViewById(R.id.individualDescriptionText);
            date = itemView.findViewById(R.id.individualDateText);
            activity = itemView.findViewById(R.id.individualActivityChip);
            String email = Objects.requireNonNull(mAuth.getCurrentUser()).getEmail();
            // Like button handler
            itemView.findViewById(R.id.likeChip).setOnClickListener(view -> {
                // Make connection to database and get the post details
                db.collection("posts").document(id).get().addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        ArrayList<String> liked = (ArrayList<String>) task.getResult().get("liked");
                        Long likes = task.getResult().getLong("likes");
                        // If there is no posts or the user has not already liked the post update relevant fields
                        if (liked != null && !liked.contains(email)) {
                            liked.add(email);
                            likes++;
                            db.collection("posts").document(id).update("likes", likes);
                            db.collection("posts").document(id).update("liked", liked);
                        } else {
                            Toast.makeText(context, "Already liked this post!", Toast.LENGTH_SHORT).show();
                        }
                    } else
                        Toast.makeText(context, "Error occurred!", Toast.LENGTH_SHORT).show();
                });
            });

            // Follow button handler
            itemView.findViewById(R.id.followChip).setOnClickListener(view -> db.collection("users").document(email).get().addOnCompleteListener(task -> {
                if (task.isSuccessful() && task.getResult() != null) {
                    ArrayList<String> following = (ArrayList<String>) task.getResult().get("following");
                    if (following != null && !following.contains(id)) {
                        // Adding the post to the user's list of following posts
                        following.add(id);
                        db.collection("users").document(email).update("following", following);
                    } else {
                        Toast.makeText(context, "Already following!", Toast.LENGTH_SHORT).show();
                    }
                }
            }));
        }

        /**
         * setters and getters for the IndividualViewHolder
         */
        public String getId() {
            return id;
        }

        public Chip getActivity() {
            return activity;
        }

        public TextView getDate() {
            return date;
        }

        public TextView getAuthor() {
            return author;
        }

        public TextView getTextViewTitle() {
            return title;
        }

        public TextView getDescription() {
            return description;
        }
    }

}