package com.qixi.security.demo.dao;

import com.qixi.security.demo.entity.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ZhengNC
 * @date 2020/9/24 10:14
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    /**
     * 根据用户名获取用户信息
     *
     * @param name
     * @return
     */
    @Query("SELECT user FROM User user WHERE user.name = :name")
    User getUserByName(@Param("name") String name);
}
