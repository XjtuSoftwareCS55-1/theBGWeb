package com.abner.DAO;

import com.abner.DO.UserDO;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<UserDO, Long> {
    @Query("select t from UserDO t where t.userId = :userId")
    UserDO findByUserId(@Param("userId") String userId);

    @SQLDelete(sql = "Delete  from sp where user_id = :userId")
    void deleteByUserId(@Param("userId")String userId);
}
