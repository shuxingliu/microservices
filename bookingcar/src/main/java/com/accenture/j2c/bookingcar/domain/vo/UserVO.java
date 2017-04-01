/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.vo;

/**
 *
 * @author darren.shuxing.liu
 * @email  darren.shuxing.liu@accenture.com shuxing.liu@gmail.com
 */
public class UserVO {

    private String location;
    private String phoneNo;

    /**
     * Custom Constructor
     *
     * @param location
     * @param phoneNo
     */
    public UserVO(String location, String phoneNo) {
        this.location = location;
        this.phoneNo = phoneNo;
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
    public String getPhoneNo() {
        return this.phoneNo;
    }

    /**
     *
     * @param phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
                .append(", phoneNo: ").append(this.phoneNo).toString();
    }

    /**
     * Default Constructor
     */
    public UserVO() {
    }    
}
