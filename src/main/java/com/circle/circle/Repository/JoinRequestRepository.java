package com.circle.circle.Repository;

import com.circle.circle.Model.JoinRequest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class JoinRequestRepository {
    private final JdbcTemplate jdbc;

    public JoinRequestRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final org.springframework.jdbc.core.RowMapper<JoinRequest> ROW_MAPPER =
            (rs, rowNum) -> new JoinRequest(
                    rs.getInt("request_id"),
                    rs.getObject("requester_id", Integer.class),
                    rs.getObject("circle_id", Integer.class),
                    rs.getObject("approver_id", Integer.class),
                    rs.getBoolean("is_approved")
            );

    public List<JoinRequest> findAll() {
        String sql = "SELECT request_id, requester_id, circle_id, approver_id, is_approved FROM circle_join_requests";
        return jdbc.query(sql, ROW_MAPPER);
    }

    public Optional<JoinRequest> findById(Integer id) {
        try {
            String sql = "SELECT request_id, requester_id, circle_id, approver_id, is_approved FROM circle_join_requests WHERE request_id = ?";
            return Optional.ofNullable(jdbc.queryForObject(sql, ROW_MAPPER, id));
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public JoinRequest create(JoinRequest jr) {
        String sql = "INSERT INTO circle_join_requests (requester_id, circle_id, approver_id, is_approved) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            // request only the generated request_id column
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "request_id" });
            if (jr.getRequesterId() != null) ps.setInt(1, jr.getRequesterId()); else ps.setNull(1, java.sql.Types.INTEGER);
            if (jr.getCircleId() != null) ps.setInt(2, jr.getCircleId()); else ps.setNull(2, java.sql.Types.INTEGER);
            if (jr.getApproverId() != null) ps.setInt(3, jr.getApproverId()); else ps.setNull(3, java.sql.Types.INTEGER);
            ps.setBoolean(4, jr.isApproved());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) jr.setRequestId(key.intValue());
        return jr;
    }

    public boolean update(JoinRequest jr) {
        String sql = "UPDATE circle_join_requests SET requester_id = ?, circle_id = ?, approver_id = ?, is_approved = ? WHERE request_id = ?";
        int updated = jdbc.update(sql,
                jr.getRequesterId(),
                jr.getCircleId(),
                jr.getApproverId(),
                jr.isApproved(),
                jr.getRequestId());
        return updated > 0;
    }

    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM circle_join_requests WHERE request_id = ?";
        int deleted = jdbc.update(sql, id);
        return deleted > 0;
    }
}