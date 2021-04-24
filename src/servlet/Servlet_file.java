package servlet;

import db.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "Servlet_file")
public class Servlet_file extends HttpServlet {
    private Object ResultSet;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dateofbirth = request.getParameter("dateofbirth");
        String gender = request.getParameter("gender");

        PrintWriter out = response.getWriter();
        out.println(name);
        out.println(username);
        out.println(email);
        out.println(password);
        out.println(dateofbirth);
        out.println(gender);

        DbConnection dbConnection = new DbConnection();
        dbConnection.insertRecord(name,username,email,password,dateofbirth,gender);

        dbConnection.getRecord(email,password);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
