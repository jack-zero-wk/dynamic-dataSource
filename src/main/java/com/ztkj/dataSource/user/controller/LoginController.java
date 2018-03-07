package com.ztkj.dataSource.user.controller;

import com.ztkj.core.entity.Response;
import com.ztkj.dataSource.user.service.UserService;
import com.ztkj.dataSource.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2017/7/18.
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userLogin")
    @ResponseBody
    public Response userLogin(@RequestBody User user){
        return null;
    }

}
