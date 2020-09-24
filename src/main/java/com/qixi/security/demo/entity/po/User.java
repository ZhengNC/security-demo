package com.qixi.security.demo.entity.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author ZhengNC
 * @date 2020/9/24 9:38
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

    /**
     * 用户ID
     */
    @Id
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String name;

    /**
     * 密码
     */
    @Column(name = "user_password")
    private String password;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;
}
