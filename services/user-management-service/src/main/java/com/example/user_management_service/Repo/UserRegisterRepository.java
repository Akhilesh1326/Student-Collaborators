package com.example.user_management_service.Repo;

import com.example.user_management_service.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface UserRegisterRepository extends JpaRepository<UserModel, UUID> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

}
