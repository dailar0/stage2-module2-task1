package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(value = "/users",loadOnStartup = 0)
public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Set<User> users = Warehouse.getInstance().getUsers();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
    }
}
