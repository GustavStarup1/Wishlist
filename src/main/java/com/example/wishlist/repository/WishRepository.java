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
    public void createWish(int wishlistId, String name, String wishText, double price, String link) {
        String query = "INSERT INTO wish(wishlist_id, name, text, price, link)" +
                "VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(query, wishlistId, name, wishText,price, link);
    }
    public Wish getWish(int id) {
        String query = "SELECT * FROM wish WHERE id = ?;";
        RowMapper<Wish> rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    public void updateWish(int id, String name, String text, double price, String link, boolean isBought) {
        System.out.println("price: " + price);
        System.out.println("desc: " + text);
        System.out.println("name: " + name);
        System.out.println("link: " + link);
        System.out.println("isBought: " + isBought);
        String query = "UPDATE wish SET name = ?, text = ?, price = ?, link = ?,  is_bought = ? WHERE id = ?;";
        jdbcTemplate.update(query, name, text, price, link, isBought, id);
    }

    public void delete(int id) {
        String query = "DELETE FROM wish Where id = ?";
        jdbcTemplate.update(query, id);
    }
    public List<Wish> getAllWishes(int id) {
        String query = "SELECT * FROM wishlist;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Wish.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void markAsBought(int id) {
        String query = "UPDATE wish SET is_bought = ? WHERE id = ?;";
        jdbcTemplate.update(query, id);
    }

    public List<Wish> getWishesByWishlistId(int id) {
        String query = "SELECT * FROM wish WHERE Wishlist_id = ?;";
        RowMapper<Wish>rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return jdbcTemplate.query(query, rowMapper, id);
    }
}

