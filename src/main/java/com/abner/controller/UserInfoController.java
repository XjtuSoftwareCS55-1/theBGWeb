package com.abner.controller;

import com.abner.DO.UserInfoDO;
import com.abner.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController {
        @Autowired
        private UserInfoService userInfoService;

        @RequestMapping(value="/index")
        public String index() {
            return "userInfo/index";
        }


    @RequestMapping(value="show")
    @ResponseBody
    public String show(@RequestParam(value ="userId")String userId){
        UserInfoDO userInfoDO = userInfoService.findUserInfoByUserId(userId);
        if(null != userInfoDO) {
            return userInfoDO.getId()+"/"+userInfoDO.getUserId()+"/" + userInfoDO.getNickName();
        }else {
            return "null";
        }
    }

    @RequestMapping(value="add")
    @ResponseBody
    public String add(@RequestParam String userId, String password, String nickname){
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserId(userId);
        userInfoDO.setNickName(nickname);
        boolean result = userInfoService.insertUser(userInfoDO);
        if(result) {
            return userInfoDO.getId()+"/"+userInfoDO.getUserId()+"/" + userInfoDO.getNickName();
        }else {
            return "null";
        }
    }
    @RequestMapping(value="update")
    @ResponseBody
    public String update(@RequestParam String userId, String password, String nickname){
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserId(userId);
        userInfoDO.setNickName(nickname);
        boolean result = userInfoService.updateUser(userInfoDO);
        if(result) {
            return userInfoDO.getId()+"/"+userInfoDO.getUserId()+"/" + userInfoDO.getNickName();
        }else {
            return "null";
        }
    }


    @RequestMapping(value="delete")
    @ResponseBody
    public String delete(@RequestParam String userId){
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserId(userId);
        boolean result = userInfoService.deleteUser(userInfoDO);
        if(result) {
            return userInfoDO.getId()+"/"+userInfoDO.getUserId()+"/" + userInfoDO.getNickName();
        }else {
            return "null";
        }
    }
}
