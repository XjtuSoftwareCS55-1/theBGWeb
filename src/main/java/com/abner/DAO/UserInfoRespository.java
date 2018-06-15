package com.abner.DAO;


import com.abner.DO.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRespository extends JpaRepository<UserInfoDO, Long> {
    @Query("select t from UserInfoDO t where t.UserId = :userId")
    UserInfoDO findByUserId(@Param("userId") String userId);
}
