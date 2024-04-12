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
public class WishListRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Wish> getAllWishes() {
        String query = "SELECT * FROM wish";
        RowMapper rowMapper = new BeanPropertyRowMapper(Wish.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void deleteWishlist(int id) {
        String query = "DELETE FROM wishlist WHERE id=?";
        jdbcTemplate.update(query, id);
    }


    public void createWishlist(String name) {
        String query = "INSERT INTO wishlist(name)" + "VALUES (?);";
        jdbcTemplate.update(query, name);
    }

    public Wishlist getWishlist(int id) {
        String query = "SELECT * FROM wishlist WHERE id = ?;";
        RowMapper<Wishlist>rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    public void updateWishlist(String name) {
        String query = "UPDATE wishlist SET Name = ? WHERE id = ?;";
        jdbcTemplate.update(query, name);

    }
    public List<Wishlist> getAllWishlists() {
        String query = "SELECT * FROM wishlist";
        RowMapper rowMapper = new BeanPropertyRowMapper(Wishlist.class);
        return jdbcTemplate.query(query, rowMapper);
    }
}
