package com.example.abar.ObserverPattern;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PostObservable implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private DatabaseReference postsReference;

    public PostObservable(String userId) {
        postsReference = FirebaseDatabase.getInstance().getReference("Posts");


        postsReference.orderByChild("publisher").equalTo(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String postId = postSnapshot.getKey();
                    notifyObservers("post", postId, userId);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String eventType, String postId, String userId) {
        for (Observer observer : observers) {
            observer.update(eventType, postId, userId);
        }
    }
}
