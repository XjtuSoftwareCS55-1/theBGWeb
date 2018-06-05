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

    @RequestMapping(value="add")
    @ResponseBody
    public String add(@RequestParam String userId, String password, String nickname){
        UserDO userDO = new UserDO();
        userDO.setUserId(userId);
        userDO.setPassword(password);
        userDO.setNickName(nickname);
        boolean result = userService.insertUser(userDO);
        if(result) {
            return userDO.getId()+"/"+userDO.getUserId()+"/" + userDO.getPassword();
        }else {
            return "null";
        }
    }
    @RequestMapping(value="update")
    @ResponseBody
    public String update(@RequestParam String userId, String password, String nickname){
        UserDO userDO = new UserDO();
        userDO.setUserId(userId);
        userDO.setPassword(password);
        userDO.setNickName(nickname);
        boolean result = userService.updateUser(userDO);
        if(result) {
            return userDO.getId()+"/"+userDO.getUserId()+"/" + userDO.getPassword();
        }else {
            return "null";
        }
    }


    @RequestMapping(value="delete")
    @ResponseBody
    public String delete(@RequestParam String userId){
        UserDO userDO = new UserDO();
        userDO.setUserId(userId);
        boolean result = userService.deleteUser(userDO);
        if(result) {
            return userDO.getId()+"/"+userDO.getUserId()+"/" + userDO.getPassword();
        }else {
            return "null";
        }
    }
}
