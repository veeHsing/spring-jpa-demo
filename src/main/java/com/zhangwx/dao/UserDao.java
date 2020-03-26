package com.zhangwx.dao;

import com.zhangwx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    @Query(value = "select count(id) from User where name = ?1 and id= ?2")
    public int countmy(String name,int id);

    @Query(value = "update User set name=?1 where   id= ?2")
    @Modifying
    public int updatemy(String name,int id);
}
