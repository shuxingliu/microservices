/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.vo;

/**
 *
 * @author darren.shuxing.liu
 */
public class DriverVO {
    private String location;
    private String carNo;

    /**
     * Custom Constructor
     *
     * @param location
     * @param carNo
     */
    public DriverVO(String location, String carNo) {
        this.location = location;
        this.carNo = carNo;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return this.location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

      /**
     *
     * @return
     */
    public String getCarNo() {
        return this.carNo;
    }

    /**
     *
     * @param carNo
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("location: ").append(this.location)
                .append(", carNo: ").append(this.carNo).toString();
    }

    /**
     * Default Constructor
     */
    public DriverVO() {
    } 
}
