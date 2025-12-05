
package com.project.auth;

public class OTPGenerator {
    public static String generateOTP() {
        // 6-digit random OTP
        int otp = (int)(Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }
}

