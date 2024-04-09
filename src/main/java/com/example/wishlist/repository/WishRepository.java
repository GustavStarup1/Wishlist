package com.example.wishlist.repository;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Wish> getAllWishes(int id) {
        String query = "SELECT * FROM wishlist;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Wish.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public List<Wish> getAllWishes() {
        String query = "SELECT * FROM wish";
        RowMapper<Wish> rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void delete(Long id) {
        String query = "DELETE FROM wish WHERE wish_id=?";
        jdbcTemplate.update(query, id);
    }

    public void insert(String text, boolean isBought) {
        String query = "INSERT INTO wish (wish_text, is_bought) VALUES (?, ?)";
        jdbcTemplate.update(query, text, isBought);
    }

    public void update(Long id, String text, boolean isBought) {
        String query = "UPDATE wish " +
                "SET wish_text = ?," +
                " is_bought = ?" +
                " WHERE wish_id = ?";
        jdbcTemplate.update(query, text, isBought, id);
    }

    public Wish getWish(int id) {
        String query = "SELECT * FROM wish WHERE wish_id = ?;";
        RowMapper<Wish> rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    public void deleteWish(int id) {
        String query = "DELETE FROM wish Where wish_id = ?";
        jdbcTemplate.update(query, id);
    }

    public void createWish(String text, boolean isBought) {
        String query = "INSERT INTO wish(wish_text, is_bought)" +
                "VALUES (?, ?);";
        jdbcTemplate.update(query, text, isBought);
    }

    public void updateWish(int id, String text, boolean isBought) {
        String query = "UPDATE wish " +
                "SET wish_text = ?," +
                "is_bought = ?" +
                "WHERE wish_id = ?;";
        jdbcTemplate.update(query,text, isBought,id);
    }
}
