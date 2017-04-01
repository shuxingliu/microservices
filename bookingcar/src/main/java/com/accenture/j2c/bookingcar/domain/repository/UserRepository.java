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
 * @param <User>
 * @param <String>
 */
public interface UserRepository<User, String> extends Repository<User, String> {

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
    public Collection<User> findByName(String name) throws Exception;
}
