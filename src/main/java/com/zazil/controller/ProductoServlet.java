package com.zazil.controller;

import com.zazil.model.Producto;
import com.zazil.model.ProductoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductoServlet", value = "/productos")
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoDao dao = new ProductoDao();
        List<Producto> lista = dao.findAll();
        req.getSession().setAttribute("productos", lista);
        resp.sendRedirect("productos.jsp");
    }
}
