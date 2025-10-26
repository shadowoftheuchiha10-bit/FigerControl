package com.example.parentalcontrol;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;

public class FingerprintHelper {

    public interface AuthenticationCallback {
        void onAuthenticated(String fingerprintId);
        void onFailed();
    }

    private FingerprintManager fingerprintManager;
    private CancellationSignal cancellationSignal;
    private AuthenticationCallback callback;

    public FingerprintHelper(Context context, AuthenticationCallback callback) {
        this.fingerprintManager = (FingerprintManager) context.getSystemService(Context.FINGERPRINT_SERVICE);
        this.callback = callback;
    }

    public void startAuth() {
        cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(null, cancellationSignal, 0, new FingerprintManager.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                // Here you'd map the fingerprint to a user
                String fingerprintId = "some_unique_id"; // Replace with real logic
                callback.onAuthenticated(fingerprintId);
            }

            @Override
            public void onAuthenticationFailed() {
                callback.onFailed();
            }
        }, null);
    }

    public void cancelAuth() {
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
    }
}
