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

        String email = request.getParameter("email");
        String otp = OTPGenerator.generateOTP();

        HttpSession session = request.getSession();
        session.setAttribute("otp",otp);
        session.setAttribute("email",email);
        session.setAttribute("otpTime",System.currentTimeMillis());
        try {
            EmailUtil.sendOTP(email, otp);
            response.sendRedirect("enterOtp.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error sending OTP: " + e.getMessage());
        }
    }

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}
