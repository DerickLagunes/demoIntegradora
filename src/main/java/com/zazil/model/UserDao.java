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

    public Object findOne(String correo, String contra) {
        User usr = new User();
        MysqlConector conector = new MysqlConector();
        Connection con = conector.connect();
        try {
            PreparedStatement stmt =
                    con.prepareStatement("select * from users " +
                            "where email = ? AND pass = sha2(?,224)");
            stmt.setString(1,correo);
            stmt.setString(2,contra);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
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

    public boolean insert(User usr){
        MysqlConector connection = new MysqlConector();
        Connection con = connection.connect();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "insert into users(email, pass, codigo) " +
                            "values(?,sha2(?,224),sha2(?,224))"
            );
            stmt.setString(1,usr.getEmail());
            stmt.setString(2,usr.getPass());
            stmt.setString(3,usr.getCodigo());
            if(stmt.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Object findOne(String correo) {
        User usr = new User();
        MysqlConector conector = new MysqlConector();
        Connection con = conector.connect();
        try {
            PreparedStatement stmt =
                    con.prepareStatement("select * from users " +
                            "where email = ?");
            stmt.setString(1,correo);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                usr.setId(res.getInt("id"));
                usr.setEmail(res.getString("email"));
                usr.setPass(res.getString("pass"));
                usr.setCodigo(res.getString("codigo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usr;
    }
}
