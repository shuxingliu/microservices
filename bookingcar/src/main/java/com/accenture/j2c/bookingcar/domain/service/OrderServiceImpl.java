/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.service;

import com.accenture.j2c.bookingcar.domain.entity.Entity;
import com.accenture.j2c.bookingcar.domain.entity.Order;
import com.accenture.j2c.bookingcar.domain.repository.OrderRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darren.shuxing.liu
 */
@Service("orderService")
public class OrderServiceImpl extends BaseService<Order, String>
        implements OrderService {

    private OrderRepository<Order, String> orderRepository;

    /**
     *
     * @param orderRepository
     */
    @Autowired
    public OrderServiceImpl(OrderRepository<Order, String> orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }

    @Override
    public void add(Order order) throws Exception {
        if (orderRepository.containsName(order.getName())) {
            throw new Exception(String.format("There is already a order with the name - %s", order.getName()));
        }

        if (order.getName() == null || "".equals(order.getName())) {
            throw new Exception("Order name cannot be null or empty string.");
        }
        super.add(order);
    }

    

    /**
     *
     * @param order
     * @throws Exception
     */
    @Override
    public void update(Order order) throws Exception {
        orderRepository.update(order);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(String id) throws Exception {
        orderRepository.remove(id);
    }

    
    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Order> findByUserId(String userId) throws Exception {
        return orderRepository.findByUserId(userId);
    }
    
    
    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(String id) throws Exception {
        return orderRepository.get(id);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Order> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
