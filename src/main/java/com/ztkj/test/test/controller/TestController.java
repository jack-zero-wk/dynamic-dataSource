package com.ztkj.test.test.controller;

import com.ztkj.core.entity.Response;
import com.ztkj.test.test.entity.Test;
import com.ztkj.test.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dell on 2017/7/18.
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Response list(@RequestBody Test test){
        List<Test> list = testService.getList();
        return Response.getSuccessInstance(list);
    }


}
