package com.circle.circle.Repository;

import com.circle.circle.Model.Node;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class NodeRepository {
    private final JdbcTemplate jdbc;

    public NodeRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final org.springframework.jdbc.core.RowMapper<Node> ROW_MAPPER =
            (rs, rowNum) -> new Node(
                    rs.getInt("node_id"),
                    rs.getObject("user_id", Integer.class),
                    rs.getObject("circle_id", Integer.class),
                    rs.getBoolean("is_circle_owner"),
                    rs.getBigDecimal("balance")
            );

    public List<Node> findAll() {
        String sql = "SELECT node_id, user_id, circle_id, is_circle_owner, balance FROM nodes";
        return jdbc.query(sql, ROW_MAPPER);
    }

    public Optional<Node> findById(Integer id) {
        try {
            String sql = "SELECT node_id, user_id, circle_id, is_circle_owner, balance FROM nodes WHERE node_id = ?";
            return Optional.ofNullable(jdbc.queryForObject(sql, ROW_MAPPER, id));
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public Node create(Node node) {
        String sql = "INSERT INTO nodes (user_id, circle_id, is_circle_owner, balance) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            // request only the generated node_id column
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "node_id" });
            if (node.getUserId() != null) ps.setInt(1, node.getUserId()); else ps.setNull(1, java.sql.Types.INTEGER);
            if (node.getCircleId() != null) ps.setInt(2, node.getCircleId()); else ps.setNull(2, java.sql.Types.INTEGER);
            ps.setBoolean(3, node.isCircleOwner());
            ps.setBigDecimal(4, node.getBalance());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) node.setNodeId(key.intValue());
        return node;
    }

    public boolean update(Node node) {
        String sql = "UPDATE nodes SET user_id = ?, circle_id = ?, is_circle_owner = ?, balance = ? WHERE node_id = ?";
        int updated = jdbc.update(sql,
                node.getUserId(),
                node.getCircleId(),
                node.isCircleOwner(),
                node.getBalance(),
                node.getNodeId());
        return updated > 0;
    }

    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM nodes WHERE node_id = ?";
        int deleted = jdbc.update(sql, id);
        return deleted > 0;
    }
}