package com.circle.circle.Model;

public class JoinRequest {
    private Integer requestId;
    private Integer requesterId;
    private Integer circleId;
    private Integer approverId;
    private boolean isApproved;

    public JoinRequest() {}

    public JoinRequest(Integer requestId, Integer requesterId, Integer circleId, Integer approverId, boolean isApproved) {
        this.requestId = requestId;
        this.requesterId = requesterId;
        this.circleId = circleId;
        this.approverId = approverId;
        this.isApproved = isApproved;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Integer requesterId) {
        this.requesterId = requesterId;
    }

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}