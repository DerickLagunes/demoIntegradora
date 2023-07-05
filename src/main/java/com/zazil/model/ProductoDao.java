package com.zazil.model;

import com.zazil.utils.MysqlConector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao implements DaoRepository{
    @Override
    public List findAll() {
        List<Producto> lista = new ArrayList<>();
        MysqlConector conector = new MysqlConector();
        Connection con = conector.connect();
        try {
            PreparedStatement stmt =
                    con.prepareStatement("select * from items");
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                Producto p = new Producto();
                p.setMedia(res.getString("media"));
                p.setItem_name(res.getString("item_name"));
                p.setDescript(res.getString("descript"));
                p.setInventory(res.getInt("inventory"));
                p.setPrice(res.getDouble("price"));
                lista.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public Object findOne(int id) {
        return null;
    }

    @Override
    public boolean update(int id, Object object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
