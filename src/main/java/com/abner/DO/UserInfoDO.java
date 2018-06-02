package com.abner.DO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserInfo")
public class UserInfoDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String UserId;
    private String NickName;
    private String Sex;
    private Date BirthDate;
    private String Description;
    private boolean Isvip;

    public void setId(long id){
        this.id = id;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setIsvip(boolean isvip) {
        Isvip = isvip;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getNickName() {
        return NickName;
    }

    public long getId() {
        return id;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public String getDescription() {
        return Description;
    }

    public String getSex() {
        return Sex;
    }

    public String getUserId() {
        return UserId;
    }

    public boolean getIsvip() {
        return Isvip;
    }
}
