package com.ztkj.dataSource.user.dao;


import com.ztkj.dataSource.user.entity.User;

/**
 * Created by dell on 2017/7/18.
 */
public interface UserDao {

    /**
     *
     * @param user
     * @return
     */
    User selectOne(User user);

}
