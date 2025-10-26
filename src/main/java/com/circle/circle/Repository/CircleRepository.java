package com.circle.circle.Repository;

import com.circle.circle.Model.Circle;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class CircleRepository {
    private final JdbcTemplate jdbc;

    public CircleRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final org.springframework.jdbc.core.RowMapper<Circle> ROW_MAPPER =
            (rs, rowNum) -> {
                Date sqlDate = rs.getDate("payment_cycle_start_date");
                LocalDate start = sqlDate != null ? sqlDate.toLocalDate() : null;
                return new Circle(
                        rs.getInt("circle_id"),
                        rs.getString("circle_name"),
                        rs.getObject("payment_cycle", Integer.class),
                        start,
                        rs.getBigDecimal("payment_amount")
                );
            };

    public List<Circle> findAll() {
        String sql = "SELECT circle_id, circle_name, payment_cycle, payment_cycle_start_date, payment_amount FROM circles";
        return jdbc.query(sql, ROW_MAPPER);
    }

    public Optional<Circle> findById(Integer id) {
        try {
            String sql = "SELECT circle_id, circle_name, payment_cycle, payment_cycle_start_date, payment_amount FROM circles WHERE circle_id = ?";
            return Optional.ofNullable(jdbc.queryForObject(sql, ROW_MAPPER, id));
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public Circle create(Circle circle) {
        String sql = "INSERT INTO circles (circle_name, payment_cycle, payment_cycle_start_date, payment_amount) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            // request only the generated circle_id column to avoid multiple-key map in KeyHolder
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "circle_id" });
            ps.setString(1, circle.getCircleName());
            if (circle.getPaymentCycle() != null) ps.setInt(2, circle.getPaymentCycle()); else ps.setNull(2, java.sql.Types.INTEGER);
            if (circle.getPaymentCycleStartDate() != null) ps.setDate(3, Date.valueOf(circle.getPaymentCycleStartDate())); else ps.setNull(3, java.sql.Types.DATE);
            ps.setBigDecimal(4, circle.getPaymentAmount());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) circle.setCircleId(key.intValue());
        return circle;
    }

    public boolean update(Circle circle) {
        String sql = "UPDATE circles SET circle_name = ?, payment_cycle = ?, payment_cycle_start_date = ?, payment_amount = ? WHERE circle_id = ?";
        int updated = jdbc.update(sql,
                circle.getCircleName(),
                circle.getPaymentCycle(),
                circle.getPaymentCycleStartDate() != null ? Date.valueOf(circle.getPaymentCycleStartDate()) : null,
                circle.getPaymentAmount(),
                circle.getCircleId());
        return updated > 0;
    }

    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM circles WHERE circle_id = ?";
        int deleted = jdbc.update(sql, id);
        return deleted > 0;
    }
}