/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.huotu.pm.repositories;

import com.huotu.pm.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author 蒋才 Jiang Cai <luffy.ja at gmail.com>
 */
@Repository
//@RepositoryRestResource(collectionResourceRel = "application", path = "application")
public interface UserRepository  extends PagingAndSortingRepository<User, Long> {
    
    /**
     * 按名字查找用户
     *
     * @param name
     * @return
     */
    User findByUsername(String name);
    
}
