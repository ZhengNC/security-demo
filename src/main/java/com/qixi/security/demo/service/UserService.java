package com.qixi.security.demo.service;

import com.qixi.security.demo.dao.UserDao;
import com.qixi.security.demo.entity.po.User;
import com.qixi.security.demo.entity.po.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ZhengNC
 * @date 2020/9/24 9:16
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        if (user != null){
            return new UserDetail(user);
        }
        throw new UsernameNotFoundException("用户不存在！");
    }


}
