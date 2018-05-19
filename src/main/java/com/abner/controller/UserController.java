package com.abner.controller;

import com.abner.DO.UserDO;
import com.abner.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/index")
    public String index() {
        return "user/index";
    }


    @RequestMapping(value="show")
    @ResponseBody
    public String show(@RequestParam(value ="userId")String userId){
        UserDO userDO = userService.findUserByUserId(userId);
        if(null != userDO) {
            return userDO.getId()+"/"+userDO.getUserId()+"/" + userDO.getPassword();
        }else {
            return "null";
        }
    }
}
