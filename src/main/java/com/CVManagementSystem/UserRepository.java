package com.CVManagementSystem;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByEmail(@Param("email") String email);

    List<User> findByUserType(@Param("userType") String userType);


}
