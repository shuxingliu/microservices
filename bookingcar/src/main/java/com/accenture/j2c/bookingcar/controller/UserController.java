/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.controller;

import com.accenture.j2c.bookingcar.domain.service.UserService;
import com.accenture.j2c.bookingcar.domain.entity.User;
import com.accenture.j2c.bookingcar.domain.entity.Entity;
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
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    /**
     *
     */
    protected static final Logger logger = Logger.getLogger(UserController.class.getName());

    /**
     *
     */
    protected UserService userService;

    /**
     *
     * @param userService
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * 通过用户名称来获得用户. 
     * http://.../v1/user?name={name}
     * @param name
     * @return 用户集合
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("订车管理微服务，通过名字查找用户：{%s} {%s} ", userService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<User> users;
        try {
            users = userService.findByName(name);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "有异常发生", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return users.size() > 0 ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * 通过id获取用户信息
     * http://.../v1/user/{id}
     * 
     *
     * @param id
     * @return 用户.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Entity> findById(@PathVariable("id") String id) {
        logger.info(String.format("订车管理微服务，通过ID查找用户：{%s} {%s} ", userService.getClass().getName(), id));
        id = id.trim();
        Entity user;
        try {
            user = userService.findById(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "异常：通过ID查找用户 {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
