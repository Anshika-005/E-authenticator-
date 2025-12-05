
package com.project.auth;



import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {

    public static void sendOTP(String toEmail, String otp) throws Exception {

        Email email = new SimpleEmail();

        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new org.apache.commons.mail.DefaultAuthenticator(
                "anshika50911@gmail.com",   // replace with your Gmail
                "tbbo zkjf zxjn rubr"       // Gmail App Password
        ));
        email.setStartTLSEnabled(true);
        email.setFrom("anshika50911@gmail.com"); // sender
        email.setSubject("Your OTP Code");
        email.setMsg("Your OTP is: " + otp + "\nValid for 5 minutes.");
        email.addTo(toEmail);

        email.send();
    }
}

