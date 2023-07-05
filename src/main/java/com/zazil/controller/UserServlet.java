package com.zazil.controller;

import com.zazil.model.User;
import com.zazil.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserDao", value = "/login")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass  = req.getParameter("pass");

        UserDao dao = new UserDao();
        User usr = (User) dao.findOne(email, pass);

        if(usr.getId()!=0){ //Que si existe un usuario en la BD
            req.getSession().setAttribute("sesion",usr);
            req.getSession().setAttribute("tipoSesion", usr.getEmail().equals("admin"));
        }

        resp.sendRedirect("index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("sesion");
        resp.sendRedirect("index.jsp");
    }
}
