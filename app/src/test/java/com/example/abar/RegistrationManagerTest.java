package com.example.abar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class RegistrationManagerTest {

    // Mock FirebaseAuth and DatabaseReference instances
    @Mock
    private FirebaseAuth mockFirebaseAuth;
    @Mock
    private DatabaseReference mockDatabaseReference;

    // Initialize the mocks before each test
    @Before
    public void setUp() {
        mockFirebaseAuth = Mockito.mock(FirebaseAuth.class);
        mockDatabaseReference = Mockito.mock(DatabaseReference.class);
        RegistrationManager.setFirebaseAuth(mockFirebaseAuth);
        RegistrationManager.setDatabaseReference(mockDatabaseReference);
    }

    // Test the singleton pattern
    @Test
    public void testSingletonPattern() {
        // Get the instance of RegistrationManager
        RegistrationManager registrationManager1 = RegistrationManager.getInstance();
        RegistrationManager registrationManager2 = RegistrationManager.getInstance();

        // Check if both instances are the same
        assertSame(registrationManager1, registrationManager2);
    }

    // Add more test cases as needed
}
