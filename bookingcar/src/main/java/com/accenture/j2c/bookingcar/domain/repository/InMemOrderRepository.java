/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.repository;

import com.accenture.j2c.bookingcar.domain.entity.Order;
import com.accenture.j2c.bookingcar.domain.entity.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;
import org.springframework.stereotype.Repository;
/**
 *
 * @author darren.shuxing.liu
 */
@Repository("orderRepository")
public class InMemOrderRepository implements OrderRepository<Order, String> {

    private Map<String, Order> entities;

    /**
     * 实际中要从数据库里读取数据，这里使用演示数据
     */
    public InMemOrderRepository() {
        entities = new HashMap();
        Order order = new Order("1", "订单1", "1", "5","从地狱到天堂", LocalDate.now(), LocalTime.now(),new BigDecimal("8888.00"));
        entities.put("1", order);
        Order order2 = new Order("2", "订单2", "1", "8","从北京到上海", LocalDate.now(), LocalTime.now(),new BigDecimal("888.00"));
        entities.put("2", order2);
        Order order3 = new Order("3", "订单3", "2", "8","从南山到福田", LocalDate.now(), LocalTime.now(),new BigDecimal("88.00"));
        entities.put("2", order3);
    }

    /**
     * Check if given order name already exist.
     *
     * @param name
     * @return true if already exist, else false
     */
    @Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    /**
     *
     * @param entity
     */
    @Override
    public void add(Order entity) {
        entities.put(entity.getId(), entity);
    }

    /**
     *
     * @param id
     */
    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    /**
     *
     * @param entity
     */
    @Override
    public void update(Order entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Entity get(String id) {
        return entities.get(id);
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<Order> getAll() {
        return entities.values();
    }
    
    
    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Order> findByName(String name) throws Exception {
        Collection<Order> orders = new ArrayList();
        int noOfChars = name.length();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.toLowerCase().subSequence(0, noOfChars))) {
                orders.add(v);
            }
        });
        return orders;
    }

    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Order> findByUserId(String userId) throws Exception {
        Collection<Order> orders = new ArrayList();
        int noOfChars = userId.length();
        entities.forEach((k, v) -> {
            if (v.getUserId().toLowerCase().contains(userId.toLowerCase().subSequence(0, noOfChars))) {
                orders.add(v);
            }
        });
        return orders;
    }

}
