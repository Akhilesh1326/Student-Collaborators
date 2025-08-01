package com.example.user_management_service.Service;


import com.example.user_management_service.DTO.UserRegisterDTO;
import com.example.user_management_service.Enums.RegistrationStatusEnum;
import com.example.user_management_service.Model.UserModel;
import com.example.user_management_service.Repo.UserRegisterRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserRegisterService {

    private UserRegisterRepository userRegisterRepository;

    private PasswordEncoder passwordEncoder;
    public UserRegisterService(UserRegisterRepository userRegisterRepository, PasswordEncoder passwordEncoder){
        this.userRegisterRepository = userRegisterRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegistrationStatusEnum.RegisterStatus createNewUser(UserRegisterDTO userRegisterDTO) {
        if(userRegisterRepository.existsByEmail(userRegisterDTO.getEmail())){
            return RegistrationStatusEnum.RegisterStatus.EMAIL_EXISTS;
        }
        if(userRegisterRepository.existsByUsername(userRegisterDTO.getUsername())){
            return RegistrationStatusEnum.RegisterStatus.USERNAME_EXISTS;
        }

        UserModel userModel = new UserModel();

        userModel.setUserName(userRegisterDTO.getUsername());
        userModel.setFirstName(userRegisterDTO.getFirstName());
        userModel.setLastName(userRegisterDTO.getLastName());
        userModel.setEmail(userRegisterDTO.getEmail());

//       Password Encoding
        String encodedPassword = passwordEncoder.encode(userRegisterDTO.getPassword());
        userModel.setPassword(encodedPassword);

        userModel.setCollegeName(userRegisterDTO.getCollegeName());
        userModel.setDepartment(userRegisterDTO.getDepartment());
        userModel.setCity(userRegisterDTO.getCity());
        userModel.setYear(userRegisterDTO.getYear());
        userModel.setState(userRegisterDTO.getState());
        userModel.setProfilePictureUrl(userRegisterDTO.getProfilePictureUrl());
        userRegisterRepository.save(userModel);
        return RegistrationStatusEnum.RegisterStatus.SUCCESS;
    }
}
