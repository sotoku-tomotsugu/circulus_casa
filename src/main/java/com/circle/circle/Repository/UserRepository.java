package com.circle.circle.Repository;

import com.circle.circle.Model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final org.springframework.jdbc.core.RowMapper<User> ROW_MAPPER =
            (rs, rowNum) -> new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password")
            );

    public List<User> findAll() {
        String sql = "SELECT user_id, username, password FROM users";
        return jdbc.query(sql, ROW_MAPPER);
    }

    public Optional<User> findById(Integer id) {
        try {
            String sql = "SELECT user_id, username, password FROM users WHERE user_id = ?";
            return Optional.ofNullable(jdbc.queryForObject(sql, ROW_MAPPER, id));
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public User create(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "user_id" });
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            user.setUserId(key.intValue());
        }
        return user;
    }

    public boolean update(User user) {
        String sql = "UPDATE users SET username = ?, password = ? WHERE user_id = ?";
        int updated = jdbc.update(sql, user.getUsername(), user.getPassword(), user.getUserId());
        return updated > 0;
    }

    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        int deleted = jdbc.update(sql, id);
        return deleted > 0;
    }
}