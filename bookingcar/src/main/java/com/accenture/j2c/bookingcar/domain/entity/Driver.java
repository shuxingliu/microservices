/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.entity;
import com.accenture.j2c.bookingcar.domain.vo.DriverVO;

/**
 *
 * @author darren.shuxing.liu
 * @email  darren.shuxing.liu@accenture.com shuxing.liu@gmail.com
 * 司机实体
 */
public class Driver extends Entity<String> {

    private DriverVO driverVo = new DriverVO();
    

    /**
     *
     * @param name
     * @param id
     * @param location
     * @param carNo
     */
    public Driver(String id, String name, String location, String carNo) {
        super(id, name);
        this.driverVo.setLocation(location); 
        this.driverVo.setCarNo(carNo);        
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return this.driverVo.getLocation();
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.driverVo.setLocation(location);
    }

    /**
     *
     * @return
     */
    public String getCarNo() {
        return this.driverVo.getCarNo();
    }

    /**
     *
     *  @param carNo
     */
    public void setCarNo(String carNo) {
        this.driverVo.setCarNo(carNo);
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
                .append(this.name).append(", ").append(this.driverVo.toString())
                .append("}").toString();
    }
}
