package com.circle.circle.Model;

import java.math.BigDecimal;

public class Node {
    private Integer nodeId;
    private Integer userId;
    private Integer circleId;
    private boolean isCircleOwner;
    private BigDecimal balance;

    public Node() {}

    public Node(Integer nodeId, Integer userId, Integer circleId, boolean isCircleOwner, BigDecimal balance) {
        this.nodeId = nodeId;
        this.userId = userId;
        this.circleId = circleId;
        this.isCircleOwner = isCircleOwner;
        this.balance = balance;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public boolean isCircleOwner() {
        return isCircleOwner;
    }

    public void setCircleOwner(boolean circleOwner) {
        isCircleOwner = circleOwner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}