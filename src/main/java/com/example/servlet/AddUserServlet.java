package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    private final Warehouse warehouse = Warehouse.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getContextPath() + "/add.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getContextPath() + "/add.jsp";

        String name = req.getParameter("firstName");
        String surname = req.getParameter("lastName");
        User user = new User(name, surname);
        warehouse.addUser(user);

        req.setAttribute("user", user);
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
