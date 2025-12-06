package com.project.auth;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/SendOTPServlet")
public class SendOTPServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("---- SendOTPServlet Called ----");

        // Get email from request
        String email = request.getParameter("email");
        System.out.println("Received Email: " + email);

        // Generate OTP
        String otp = OTPGenerator.generateOTP();
        System.out.println("Generated OTP: " + otp);

        // Store OTP in session
        HttpSession session = request.getSession();
        session.setAttribute("otp", otp);
        session.setAttribute("email", email);
        session.setAttribute("otpTime", System.currentTimeMillis());

        System.out.println("Session Created: " + session.getId());
        System.out.println("OTP + Email stored in session");

        try {
            // Send email
            EmailUtil.sendOTP(email, otp);
            System.out.println("OTP Email Sent Successfully");

            // Redirect to OTP entry page
            response.sendRedirect("enterOtp.jsp");
            System.out.println("Redirected to enterOtp.jsp");

        } catch (Exception e) {
            System.out.println("ERROR while sending OTP:");
            e.printStackTrace(); // This will also show in Render logs

            response.getWriter().println("Error sending OTP: " + e.getMessage());
        }

        System.out.println("---- SendOTPServlet Finished ----");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("GET request received, forwarding to POST");
        doPost(request, response);
    }
}
