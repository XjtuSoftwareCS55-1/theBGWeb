package com.abner.Service;

import com.abner.DAO.UserInfoRespository;
import com.abner.DO.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRespository userInfoRespository;

    public UserInfoDO findUserInfoByUserId(String userId) {
        UserInfoDO userInfoDO = null;
        try {
            userInfoDO = userInfoRespository.findByUserId(userId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return userInfoDO;
    }

    public boolean insertUser(UserInfoDO userInfoDO){
        UserInfoDO result = findUserInfoByUserId(userInfoDO.getUserId());
        if(null != result) {
            userInfoDO.setId(result.getId());
        }
        try {
            UserInfoDO result1 = userInfoRespository.save(userInfoDO);
//            System.out.println(result.getId()+"/"+result.getUserId()+"/" + result.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteUser(UserInfoDO userInfoDO) {
        try{
//            userInfoRespository.deleteByUserId(UserInfoDO.getUserId());
            userInfoRespository.delete(userInfoRespository.findByUserId(userInfoDO.getUserId()));
        }catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateUser(UserInfoDO userInfoDO) {
        UserInfoDO result = findUserInfoByUserId(userInfoDO.getUserId());
        if(null != result) {
            userInfoDO.setId(result.getId());
        } else {
            return false;
        }
        try {
            UserInfoDO result1 = userInfoRespository.save(userInfoDO);
//            System.out.println(result.getId()+"/"+result.getUserId()+"/" + result.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
