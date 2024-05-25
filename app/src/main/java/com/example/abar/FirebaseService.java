package com.example.abar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public interface FirebaseService {
    FirebaseAuth getFirebaseAuth();
    FirebaseDatabase getFirebaseDatabase();
}
