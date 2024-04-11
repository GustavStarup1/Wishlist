package com.example.wishlist.repository;
import com.example.wishlist.model.Wish;
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
    public void createWish(int wishlistId, String name, String wishText, double price, String link, boolean isBought, String isReservedByUserId) {
        String query = "INSERT INTO wish(wishlist_id, name, wish_text, price, link,is_bought,is_reserved_by_user_id)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(query, wishlistId, name, wishText,price, link, isBought, isReservedByUserId);
    }
    public Wish getWish(int id) {
        String query = "SELECT * FROM wish WHERE wish_id = ?;";
        RowMapper<Wish> rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    public void updateWish(int id, String text, boolean isBought) {
        String query = "UPDATE wish " +
                "SET wish_text = ?," +
                "is_bought = ?" +
                "WHERE wish_id = ?;";
        jdbcTemplate.update(query,text, isBought,id);
    }
    public void delete(int id) {
        String query = "DELETE FROM wish Where wish_id = ?";
        jdbcTemplate.update(query, id);
    }
    public List<Wish> getAllWishes(int id) {
        String query = "SELECT * FROM wishlist;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Wish.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void markAsBought(int id) {
        String query = "UPDATE wish SET is_bought = ? WHERE wish_id = ?;";
        jdbcTemplate.update(query, id);
    }
}

