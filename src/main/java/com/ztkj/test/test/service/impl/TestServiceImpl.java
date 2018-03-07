package com.ztkj.test.test.service.impl;


import com.ztkj.test.test.dao.TestDao;
import com.ztkj.test.test.entity.Test;
import com.ztkj.test.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/7/18.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> getList() {
        return testDao.getTest();
    }
}
