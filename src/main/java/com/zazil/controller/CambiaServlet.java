package com.zazil.controller;

import com.zazil.model.User;
import com.zazil.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CambiaServlet", value = "/CambiaServlet")
public class CambiaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass = req.getParameter("pass");
        int id = Integer.parseInt(req.getParameter("id"));

        UserDao dao = new UserDao();
        User usr = (User) dao.findOne(id);
        usr.setPass(pass);
        usr.setCodigo(Math.random()+"");

        dao.update(id,usr);

        req.getSession().removeAttribute("infoContra");
        req.getSession().removeAttribute("sesion");
        req.getSession().removeAttribute("tipoSesion");

        req.getSession().setAttribute("operacion",
                "Se cambio la contraseña existosamente");
        resp.sendRedirect("index.jsp");


    }
}
