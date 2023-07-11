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
                    String url = req.getRequestURL().toString();
                    mail.sendEmail(
                            usr.getEmail(),
                            "Recuperación de contraseña",
                            "Has solicitado la recuperacion " +
                                    "de tu contraseña para la pagina " +
                                    "web de zail </br></br> por favor " +
                                    "da click en el siguiente enlace para " +
                                    "recuperar tu contraseña:</br>" +
                                    "<a href=\""+url+"?codigo="+usr.getCodigo()+"\">Recuperación</a>",
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

        req.getSession().setAttribute("operacion",
                "Porfavor revisa tu correo electronico para continuar el proceso de cambio de contraseña");
        resp.sendRedirect("index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codigo = req.getParameter("codigo");
        String url = "index.jsp";
        /*
        1 usamos el codigo para checar si existe
        en la base de datos y recuperar la información del
        usuario
        */
        UserDao dao = new UserDao();
        User usr = (User) dao.findCodigo(codigo);
        if (usr.getId()==0){
            url = "index.jsp";
            req.getSession().setAttribute("operacion",
                    "Ese codigo ya no es valido :)");
        }else{
            if(usr.getCodigo().isEmpty()){
                //Que no existe el codigo en la BD
                //Avisarle al usuario o no
            }else{
                //Que si existe la información
                req.getSession().setAttribute("infoContra",usr);
                url="cambiarContrasena.jsp";
            /*
        1.5 Obtener la nueva contraseña del usuario
        2. Hacer el update del campo contraseña del usuario
        Y DEL CAMPO CODIGO <--- mediante java con un String random
        3. Quitar toda la informacion de las sesiones y regresar
        al index.jsp
         */
            }
        }

        resp.sendRedirect(url);
    }
}
