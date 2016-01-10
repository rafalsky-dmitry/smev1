package com.iisc.year2015;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        JsonReader reader = Json.createReader(request.getInputStream());
        JsonObject newJson = reader.readObject();
        reader.close();
        String username = newJson.getString("name");
        String password = newJson.getString("pas");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        workdatabase wdb = new workdatabase();
        out.print(wdb.checkUser(username, password));
        //out.print(username + ' ' + password);
    }
}
