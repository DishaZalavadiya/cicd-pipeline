package com.myapp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>✅ CI/CD Pipeline Working on AWS EC2!</h1>");
        out.println("<p>Auto-deployed by Jenkins on Amazon Linux</p>");
    }
}
