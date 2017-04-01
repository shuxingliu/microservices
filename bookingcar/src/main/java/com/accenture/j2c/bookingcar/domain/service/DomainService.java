/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.domain.service;

import java.util.Collection;


/**
 *
 * @author darren.shuxing.liu
 * @param <TE>
 * @param <T>
 * 
 */
public interface DomainService<TE, T> {
    /**
     *
     * @param te
     * @throws Exception
     */
    public void add(TE te) throws Exception;

    /**
     *
     * @param te
     * @throws Exception
     */
    public void update(TE te) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(T id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public TE findById(T id) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<TE> findByName(String name) throws Exception;    
}
