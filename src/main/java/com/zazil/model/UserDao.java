package com.zazil.model;

import com.zazil.utils.MysqlConector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements DaoRepository {

    @Override
    public List findAll() {
        List<User> listaUsuarios = new ArrayList<>();
        MysqlConector conn = new MysqlConector();
        Connection con = conn.connect();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from users");
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                User usr = new User();
                usr.setId(res.getInt("id"));
                usr.setEmail(res.getString("email"));
                usr.setPass(res.getString("pass"));
                listaUsuarios.add(usr);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    @Override
    public Object findOne(int id) {
        return null;
    }

    public Object login(String user, String pass) {
        User usr = new User();
        MysqlConector conn = new MysqlConector();
        Connection con = conn.connect();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from users where email = ? AND pass = sha2(?,224)");
            stmt.setString(1,user);
            stmt.setString(2,pass);
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                usr.setId(res.getInt("id"));
                usr.setEmail(res.getString("email"));
                usr.setPass(res.getString("pass"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usr;
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
