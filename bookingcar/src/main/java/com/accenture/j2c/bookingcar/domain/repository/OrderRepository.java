/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.repository;
import java.util.Collection;

/**
 *
 * @author darren.shuxing.liu
 * @param <Order>
 * @param <String>
 */
public interface OrderRepository<Order, String> extends Repository<Order, String> {

    /**
     *
     * @param name
     * @return
     */
    boolean containsName(String name);
    
    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Order> findByName(String name) throws Exception;

    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public Collection<Order> findByUserId(String userId) throws Exception;
}