/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.entity;

import com.accenture.j2c.bookingcar.domain.vo.UserVO;
/**
 *
 * @author darren.shuxing.liu
 * @email  darren.shuxing.liu@accenture.com shuxing.liu@gmail.com
 * 用户实体
 */
public class User extends Entity<String> {

    private UserVO userVo = new UserVO();
    

    /**
     *
     * @param name
     * @param id
     * @param location
     * @param phoneNo
     */
    public User(String id, String name, String location, String phoneNo) {
        super(id, name);
        this.userVo.setLocation(location); 
        this.userVo.setPhoneNo(phoneNo);        
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return this.userVo.getLocation();
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.userVo.setLocation(location);
    }

    /**
     *
     * @return
     */
    public String getPhoneNo() {
        return this.userVo.getPhoneNo();
    }

    /**
     *
     * @param phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.userVo.setPhoneNo(phoneNo);
    }

    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(this.id).append(", name: ")
                .append(this.name).append(", ").append(this.userVo.toString())
                .append("}").toString();
    }
}
