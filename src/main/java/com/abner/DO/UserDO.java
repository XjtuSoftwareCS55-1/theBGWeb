package com.abner.DO;


import com.abner.Util.Md5Util;

import javax.persistence.*;

@Entity
@Table(name = "SP")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userId;

    private String password;

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setPassword(String password){
        String tmp = "";
        try{
             tmp= Md5Util.md5Encode(password);
        }catch (Exception e){
            tmp = password;
        }finally {
            this.password = tmp;
        }
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }
}

