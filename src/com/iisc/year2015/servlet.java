package com.iisc.year2015;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dmitry on 25.11.2015.
 */
@WebServlet("/login")
public class servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {

        String username = req.getParameter("name");
        String password = req.getParameter("pas");
        //String username = "master";
        //String password = "yoda";


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (username.equals("master") && password.equals("yoda")) {
            out.print("Welcome");
        } else {
            out.print("Incorrect login or password");
        }
    }
}
