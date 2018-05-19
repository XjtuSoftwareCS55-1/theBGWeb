package com.abner.Service;

import com.abner.DAO.UserRespository;
import com.abner.DO.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;
    public UserDO findUserByUserId(String userId) {
        UserDO userDO = null;
        try{
            userDO = userRespository.findByUserId(userId);
        }catch (Exception e){

        }
        return userDO;
    }
}
