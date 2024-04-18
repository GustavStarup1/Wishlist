package com.example.wishlist.repository;

import com.example.wishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
@Autowired
    JdbcTemplate jdbcTemplate;

    public User login(String username, String password) {
        String query = "SELECT * FROM wishlist_project.user where username = ? and password = ?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(query, rowMapper, username, password);
    }

    public void createLogin(String username, String password, String email) {
        String query = "INSERT INTO user(username, password, email)" + "VALUES (?, ?, ?);";
        jdbcTemplate.update(query, username, password, email);
    }
}
