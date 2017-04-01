/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.vo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;
/**
 *
 * @author darren.shuxing.liu
 */
public class OrderVO {
    private LocalDate date;
    private LocalTime time;
    private String journey;
    private BigDecimal amount;

    /**
     *
     * @return
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public LocalTime getTime() {
        return this.time;
    }

    /**
     *
     * @param time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    /**
     *
     * @return
     */
    public String getJourney() {
        return this.journey;
    }

    /**
     *
     * @param journey
     */
    public void setJourney(String journey) {
        this.journey = journey;
    }
    
    /**
     *
     * @return
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Default Constructor
     */
    public OrderVO() {
    }

    /**
     * Custom Constructor
     *
     * 
     * @param time
     * @param date
     * @param journey
     * @param amount
     */
    public OrderVO(LocalDate date, LocalTime time, String journey, BigDecimal amount) {
        this.date = date;
        this.time = time;
        this.journey = journey;
        this.amount = amount;
    }

    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("date: ").append(this.date)
                .append(", time: ").append(this.time)
                .append(", journey: ").append(this.journey)
                .append(", amount: ").append(this.amount)
                .append("}").toString();
    }
}
