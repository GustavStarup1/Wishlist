package com.example.wishlist.repository;
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
    public Wishlist getWish(Long id) {
        String query = "SELECT * FROM wishes WHERE id = ?";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    public List<Wishlist> getWishes() {
        String query = "SELECT * FROM wishes";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void delete(Long id) {
        String query = "DELETE FROM wishes WHERE id=?";
        jdbcTemplate.update(query, id);
    }

    public void insert(String text, boolean isBought) {
        String query = "INSERT INTO wishes (text, is_bought) VALUES (?, ?)";
        jdbcTemplate.update(query, text, isBought);
    }

    public void update(Long id, String text, boolean isBought) {
        String query = "UPDATE wishes " +
                "SET text = ?," +
                " is_bought = ?" +
                " WHERE id = ?";
        jdbcTemplate.update(query, text, isBought, id);
    }

}
