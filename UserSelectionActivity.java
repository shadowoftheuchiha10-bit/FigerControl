package com.example.parentalcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.parentalcontrol.models.User;

public class UserSelectionActivity extends Activity {

    private FingerprintHelper fingerprintHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fingerprintHelper = new FingerprintHelper(this, new FingerprintHelper.AuthenticationCallback() {
            @Override
            public void onAuthenticated(String fingerprintId) {
                // Lookup user by fingerprintId, show user dashboard
                User user = findUserByFingerprint(fingerprintId);
                if (user != null) {
                    // Proceed to MainActivity for this user
                    Toast.makeText(UserSelectionActivity.this, "Welcome " + user.getName(), Toast.LENGTH_SHORT).show();
                    // TODO: Start MainActivity with user info
                } else {
                    Toast.makeText(UserSelectionActivity.this, "Unknown fingerprint!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailed() {
                Toast.makeText(UserSelectionActivity.this, "Fingerprint not recognized. Try again.", Toast.LENGTH_SHORT).show();
            }
        });

        fingerprintHelper.startAuth();
    }

    private User findUserByFingerprint(String fingerprintId) {
        // TODO: Implement lookup (e.g., query local database)
        return null;
    }

    @Override
    protected void onDestroy() {
        fingerprintHelper.cancelAuth();
        super.onDestroy();
    }
}