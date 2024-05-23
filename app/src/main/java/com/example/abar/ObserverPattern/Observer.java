package com.example.abar.ObserverPattern;

public interface Observer {
    void update(String eventType, String postId, String userId);
}
