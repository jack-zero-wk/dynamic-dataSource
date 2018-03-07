package com.ztkj.dataSource.user.service.impl;

import com.ztkj.core.bean.DataSourceEntity;
import com.ztkj.dataSource.ds.dao.DSDao;
import com.ztkj.core.redis.RedisClientTemplate;
import com.ztkj.dataSource.user.service.UserService;
import com.ztkj.dataSource.user.dao.UserDao;
import com.ztkj.dataSource.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/7/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DSDao dsDao;

    @Autowired
    RedisClientTemplate redisClientTemplate;

    @Override
    public User selectUser(User user) {
//        user.setPassword();
        User user1 = userDao.selectOne(user);
        if(user1!=null){
            //缓存用户
            redisClientTemplate.set("user_"+user1.getId(),user1);

            //根据用户id查询出对应的数据源
            DataSourceEntity dataSourceEntity = dsDao.getDataSourceByUserId(user1.getId());
            //缓存数据源
            redisClientTemplate.set("ds_user_"+user1.getId(),dataSourceEntity);

        }
        return user1;
    }
}
