package com.example.abar.ObserverPattern;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StoryObservable implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private DatabaseReference storiesReference;

    public StoryObservable(String userId) {
        storiesReference = FirebaseDatabase.getInstance().getReference("Story");


        storiesReference.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot storySnapshot : dataSnapshot.getChildren()) {
                    String storyId = storySnapshot.getKey();
                    notifyObservers("story", storyId, userId);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
    public void notifyObservers(String eventType, String storyId, String userId) {
        for (Observer observer : observers) {
            observer.update(eventType, storyId, userId);
        }
    }
}
