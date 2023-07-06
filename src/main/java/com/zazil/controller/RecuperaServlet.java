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

@WebServlet(name = "RecuperServlet", value = "/RecuperaServlet")
public class RecuperaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");

        if (!email.isEmpty()){
            UserDao dao = new UserDao();
            User usr = (User) dao.findOne(email);
            if (usr.getId()!=0){
                //si existe un usuario con ese correo en la base de datos
                SendEmail mail = new SendEmail();
                try {
                    mail.sendEmail(
                            usr.getEmail(),
                            "Recuperación de contraseña",
                            "Has solicitado la recuperacion " +
                                    "de tu contraseña para la pagina " +
                                    "web de zail </br></br> por favor " +
                                    "da click en el siguiente enlace para " +
                                    "recuperar tu contraseña:</br>" +
                                    "<a href=\"modificarContra.jsp?codigo="+usr.getCodigo()+"\">Recuperación</a>",
                            new File(
                                    req.getSession().
                                            getServletContext().
                                            getResource("/assets/img/logo.png").
                                            toURI()));
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
