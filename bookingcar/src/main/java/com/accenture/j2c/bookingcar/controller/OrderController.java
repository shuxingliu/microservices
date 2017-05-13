/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.controller;

import com.accenture.j2c.bookingcar.domain.entity.Entity;
import com.accenture.j2c.bookingcar.domain.entity.Order;
import com.accenture.j2c.bookingcar.domain.service.OrderService;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author darren.shuxing.liu
 * @email  darren.shuxing.liu@accenture.com shuxing.liu@gmail.com
 */
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    /**
     *
     */
    protected static final Logger logger = Logger.getLogger(OrderController.class.getName());

    /**
     *调用领域服务
     */
    protected OrderService orderService;

    /**
     *OrderController的构造函数
     * @param userService
     */
    @Autowired
    public OrderController(OrderService userService) {
        this.orderService = userService;
    }
    
    /**
     * 通过用户ID来获得订单. 
     * http://.../v1/order?userid={userid}
     * @param userId
     * @return 订单集合
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Order>> findByUserId(@RequestParam("userid") String userId) {
        logger.info(String.format("订车管理微服务，通过用户ID查找订单：invoked by {%s}, userId {%s}", 
                orderService.getClass().getName(), userId));
        userId = userId.trim();
        Collection<Order> orders;
        try {
            orders = orderService.findByUserId(userId);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, " 异常:{0} ", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return orders.size() > 0 ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
        
    
    /**
     * 通过id获取订单信息
     * http://.../v1/order/{id}
     * 
     *
     * @param id
     * @return 订单.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Entity> findById(@PathVariable("id") String id) {
        logger.info(String.format("订车管理微服务，通过订单ID查找订单：invoked by {%s}, order id {%s} ", 
                orderService.getClass().getName(), id));
        id = id.trim();
        Entity order;
        try {
            order = orderService.findById(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "异常：{0} ", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return order != null ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    /**
     * 数据服务
     * 通过Order ID来获得订单名称. 
     * http://.../v1/order/name/{id}
     * @param id
     * @return 订单名称
     */
    @RequestMapping(value = "/name/{id}", method = RequestMethod.GET)
    public String getOrderName(@PathVariable("id") String id) {
        id = id.trim();
        Entity order;
        try {
            order = orderService.findById(id);
        } catch (Exception ex) {
            return "Exception happened";
        }
        return order != null ? order.getName() : "No such order";        
    }
}

