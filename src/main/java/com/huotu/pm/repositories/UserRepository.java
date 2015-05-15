/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.huotu.pm.repositories;

import com.huotu.pm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 蒋才 Jiang Cai <luffy.ja at gmail.com>
 */
@Repository
//@Transactional
//@RepositoryRestResource(collectionResourceRel = "application", path = "application")
public interface UserRepository  extends JpaRepository<User, Long> {
    
    /**
     * 按名字查找用户
     *
     * @param name
     * @return
     */
    User findByUsername(String name);
    
}
