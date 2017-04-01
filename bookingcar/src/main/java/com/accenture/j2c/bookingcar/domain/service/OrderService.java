/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.service;

import com.accenture.j2c.bookingcar.domain.entity.Entity;
import com.accenture.j2c.bookingcar.domain.entity.Order;
import java.util.Collection;


/**
 *
 * @author darren.shuxing.liu
 */
public interface OrderService {
    /**
     *
     * @param order
     * @throws Exception
     */
    public void add(Order order) throws Exception;

    /**
     *
     * @param order
     * @throws Exception
     */
    public void update(Order order) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public Collection<Order> findByUserId(String userId) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(String id) throws Exception;    
}
