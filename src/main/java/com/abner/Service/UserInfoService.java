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

        }
        return userInfoDO;
    }

    public boolean insert

}
