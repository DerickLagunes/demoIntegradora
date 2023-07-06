package com.zazil.controller;

import com.zazil.model.User;
import com.zazil.model.UserDao;
import com.zazil.utils.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/login")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass  = req.getParameter("pass");
        String registro = req.getParameter("registro");

        UserDao dao = new UserDao();
        if(registro != null){
            //lógica de programación para un registro de usuario
            dao.insert(new User(0, email, pass, "cod"));
            //Aveces, no siempre, te mandan un email de bienvenida
            /*SendEmail mail = new SendEmail();
            try {
                mail.sendEmail(
                        "dericklagunes@utez.edu.mx",
                        "Prueba de envio",
                        "<h1>Hola como estas</h1>",
                        new File(
                                req.getSession().
                                        getServletContext().
                                        getResource("/assets/img/logo.png").
                                        toURI()));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }*/
        }else{
            //lógica de programación para un login
            User usr = (User) dao.findOne(email, pass);

            if(usr.getId()!=0){ //Que si existe un usuario en la BD
                req.getSession().setAttribute("sesion",usr);
                req.getSession().setAttribute("tipoSesion", usr.getEmail().equals("admin"));
            }
        }
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("sesion");
        resp.sendRedirect("index.jsp");
    }
}
