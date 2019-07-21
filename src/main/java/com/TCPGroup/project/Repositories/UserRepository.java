package com.TCPGroup.project.Repositories;

import com.TCPGroup.project.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {


    User getById(Integer id);

    List<User> findAllByIdIn(List<Integer> ids);

    @Query(value = "SELECT * FROM heroku_884cbef5c97b2c4.user t where t.username = :username and t.password = :password",
            nativeQuery = true)
    User authenticateUser(@Param("username") String username, @Param("password") String passwordToCheck);
}
