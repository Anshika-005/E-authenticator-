package com.project.auth;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {

    public static void sendOTP(String toEmail, String otp) throws Exception {

        SimpleEmail email = new SimpleEmail();

        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthentication("anshika50911@gmail.com", "tbbo zkjf zxjn rubr");

        email.setStartTLSEnabled(true);
        email.setStartTLSRequired(true);

        // ⭐ VERY IMPORTANT FIX FOR RENDER
        email.setSslSmtpPort("587");
        email.setSSLOnConnect(false);
        email.setSslSmtpPort("587");
        email.getMailSession().getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");

        email.setFrom("anshika50911@gmail.com");
        email.setSubject("Your OTP Code");
        email.setMsg("Your OTP is: " + otp + "\nValid for 5 minutes.");
        email.addTo(toEmail);

        email.send();
    }
}
