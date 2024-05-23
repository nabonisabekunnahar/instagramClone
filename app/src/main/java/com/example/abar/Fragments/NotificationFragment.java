package com.example.abar.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abar.Adapter.NotificationAdapter;
import com.example.abar.Model.Notification;
import com.example.abar.ObserverPattern.Observable;
import com.example.abar.ObserverPattern.Observer;
import com.example.abar.ObserverPattern.PostObservable;
import com.example.abar.ObserverPattern.StoryObservable;
import com.example.abar.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NotificationFragment extends Fragment implements Observer {

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
    private List<Notification> notificationList;
    private PostObservable postObservable;
    private StoryObservable storyObservable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        notificationList = new ArrayList<>();
        notificationAdapter = new NotificationAdapter(getContext(), notificationList);
        recyclerView.setAdapter(notificationAdapter);

        postObservable = new PostObservable(FirebaseAuth.getInstance().getCurrentUser().getUid());
        postObservable.addObserver(this);

        storyObservable = new StoryObservable(FirebaseAuth.getInstance().getCurrentUser().getUid());
        storyObservable.addObserver(this);

        readNotifications();

        return view;
    }


    private void readNotifications() {

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Notifications").child(firebaseUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                notificationList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Notification notification = snapshot.getValue(Notification.class);
                    notificationList.add(notification);
                }

                Collections.reverse(notificationList);
                notificationAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void update(String eventType, String postId, String userId) {
        if ("post".equals(eventType) || "story".equals(eventType)) {

           readNotifications();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (postObservable != null) {
            postObservable.removeObserver(this);
        }
        if (storyObservable != null) {
            storyObservable.removeObserver(this);
        }
    }

}