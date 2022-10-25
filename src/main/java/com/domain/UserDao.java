package com.domain;

import com.dao.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.*;
import java.util.Map;

public class UserDao {
    private ConnectionMaker connectionMaker;

    public UserDao() {
        connectionMaker = new awsConnectionMaker();
    }

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) {

        try {

            Connection c = connectionMaker.makeConnection();


            PreparedStatement pstmt = c.prepareStatement("INSERT INTO users(id, name, password) VALUES(?,?,?);");
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());


            pstmt.executeUpdate();

            pstmt.close();
            c.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(String id) {

        try {
            Connection c = connectionMaker.makeConnection();


            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM users WHERE id = ?");
            pstmt.setString(1, id);


            ResultSet rs = pstmt.executeQuery();
            User user = null;
            if(rs.next()){
                user = new User(rs.getString("id"), rs.getString("name"),
                        rs.getString("password"));
            }


            rs.close();
            pstmt.close();
            c.close();

            if(user ==null)
                throw new EmptyResultDataAccessException(1);

            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() {
        try {
            Connection c = connectionMaker.makeConnection();
            PreparedStatement pstmt = c.prepareStatement("Delete from users");
            pstmt.executeUpdate();
            pstmt.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int GetCount() {


        try {
            Connection c = connectionMaker.makeConnection();
            PreparedStatement pstmt = c.prepareStatement("SELECT count(*) from users");
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            int count= rs.getInt(1);


            rs.close();
            pstmt.close();
            c.close();

            return count;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }







}



