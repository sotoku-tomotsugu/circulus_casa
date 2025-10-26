package com.circle.circle.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Circle {

    private Integer circleId;
    private String circleName;
    private Integer paymentCycle;
    private LocalDate paymentCycleStartDate;
    private BigDecimal paymentAmount;

    public Circle() {}

    public Circle(Integer circleId, String circleName, Integer paymentCycle, LocalDate paymentCycleStartDate, BigDecimal paymentAmount) {
        this.circleId = circleId;
        this.circleName = circleName;
        this.paymentCycle = paymentCycle;
        this.paymentCycleStartDate = paymentCycleStartDate;
        this.paymentAmount = paymentAmount;
    }

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public Integer getPaymentCycle() {
        return paymentCycle;
    }

    public void setPaymentCycle(Integer paymentCycle) {
        this.paymentCycle = paymentCycle;
    }

    public LocalDate getPaymentCycleStartDate() {
        return paymentCycleStartDate;
    }

    public void setPaymentCycleStartDate(LocalDate paymentCycleStartDate) {
        this.paymentCycleStartDate = paymentCycleStartDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}