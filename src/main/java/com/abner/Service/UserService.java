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
            e.printStackTrace();
        }
        return userDO;
    }

    public boolean insertUser(UserDO userDO) {
        UserDO result = findUserByUserId(userDO.getUserId());
        if(null != result) {
            userDO.setId(result.getId());
        }
        try {
            UserDO result1 = userRespository.save(userDO);
//            System.out.println(result.getId()+"/"+result.getUserId()+"/" + result.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteUser(UserDO userDO) {
        try{
//            userRespository.deleteByUserId(userDO.getUserId());
            userRespository.delete(userRespository.findByUserId(userDO.getUserId()));
        }catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateUser(UserDO userDO) {
        UserDO result = findUserByUserId(userDO.getUserId());
        if(null != result) {
            userDO.setId(result.getId());
        } else {
            return false;
        }
        try {
            UserDO result1 = userRespository.save(userDO);
//            System.out.println(result.getId()+"/"+result.getUserId()+"/" + result.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
