package com.example.abar.ObserverPattern;

import junit.framework.TestCase;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class ObservableTest {

    @Test
    public void testNotifyObservers() {
        // Create a mock Observer
        Observer observer1 = mock(Observer.class);
        Observer observer2 = mock(Observer.class);

        // Create a mock implementation of Observable
        Observable observable = new Observable() {
            @Override
            public void addObserver(Observer observer) {

            }

            @Override
            public void removeObserver(Observer observer) {

            }

            @Override
            public void notifyObservers(String eventType, String postId, String userId) {
                // Call update on each observer
                observer1.update(eventType, postId, userId);
                observer2.update(eventType, postId, userId);
            }
        };

        // Notify observers
        observable.notifyObservers("testEventType", "testPostId", "testUserId");

        // Verify that update was called with the correct parameters for both observers
        verify(observer1).update("testEventType", "testPostId", "testUserId");
        verify(observer2).update("testEventType", "testPostId", "testUserId");
    }
}
