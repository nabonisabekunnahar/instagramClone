package com.example.abar.ObserverPattern;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String eventType, String postId, String userId);
}
