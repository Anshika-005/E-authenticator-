/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.auth;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/VerifyOTPServlet")
public class VerifyOTPServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userOtp = request.getParameter("otp");
        HttpSession session = request.getSession();
        String realOtp = (String) session.getAttribute("otp");
        long otpTime = (long) session.getAttribute("otpTime");

        // check if OTP expired (5 min = 300000 ms)
        if (System.currentTimeMillis() - otpTime > 300000) {
            response.getWriter().println("<div style='text-align:center; margin-top:200px; font-size:28px; color:#e63946;'>"
            + "OTP expired! Please try again."
            + "</div>");
            return;
        }

        if (userOtp.equals(realOtp)) {
            response.getWriter().println("<div style='text-align:center; margin-top:200px; font-size:40px; font-weight:bold; color:#2a9d8f;'>"
            + "OTP Verified Successfully!"
            + "</div>");
        } else {
            response.getWriter().println("<div style='text-align:center; margin-top:200px; font-size:32px; font-weight:bold; color:#d62828;'>"
            + "Invalid OTP!"
            + "</div>");
        }
    }
}
