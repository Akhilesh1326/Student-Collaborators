package com.example.user_management_service.Service;


import com.example.user_management_service.DTO.UserLogInDTO;
import com.example.user_management_service.Enums.RegistrationStatusEnum;
import com.example.user_management_service.Repo.UserLoginRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class UserLogInService {

    private PasswordEncoder passwordEncoder;

    private UserLoginRepository userLoginRepository;
    public UserLogInService(UserLoginRepository userLoginRepository){
        this.userLoginRepository = userLoginRepository;
    }
    public RegistrationStatusEnum.RegisterStatus userLogInCheck(UserLogInDTO userLogInDTO) {
        if(userLoginRepository.existsByUsername(userLogInDTO.getUsername())) {
            return RegistrationStatusEnum.RegisterStatus.USERNAME_EXISTS;
        }
        String encodedPass = passwordEncoder.encode(userLogInDTO.getPassword());
        if(userLoginRepository.existsByPassword(encodedPass)){
            return RegistrationStatusEnum.RegisterStatus.SUCCESS;
        }

        return RegistrationStatusEnum.RegisterStatus.ERROR;
    }
}
