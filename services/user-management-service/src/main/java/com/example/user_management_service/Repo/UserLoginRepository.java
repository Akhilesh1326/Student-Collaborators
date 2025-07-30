package com.example.user_management_service.Repo;


import com.example.user_management_service.DTO.UserLogInDTO;
import com.example.user_management_service.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserLoginRepository extends JpaRepository<UserModel,UUID> {

    boolean existsByUsername(String username);
    boolean existsByPassword(String password);


}
