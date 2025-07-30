package com.example.user_management_service.Service;


import com.example.user_management_service.DTO.UserLogInDTO;
import com.example.user_management_service.Enums.RegistrationStatusEnum;
import com.example.user_management_service.Repo.UserLoginRepository;
import com.example.user_management_service.Repo.UserRegisterRepository;
import org.springframework.stereotype.Service;

@Service
public class UserLogInService {

    private UserLoginRepository userLoginRepository;
    public UserLogInService(UserLoginRepository userLoginRepository){
        this.userLoginRepository = userLoginRepository;
    }
    public RegistrationStatusEnum.RegisterStatus userLogInCheck(UserLogInDTO userLogInDTO) {
        if(userLoginRepository.existsByUsername(userLogInDTO.getUsername())) {
            return RegistrationStatusEnum.RegisterStatus.USERNAME_EXISTS;
        }
        if(userLoginRepository.existsByPassword(userLogInDTO.getPassword())){
            return RegistrationStatusEnum.RegisterStatus.SUCCESS;
        }

        return RegistrationStatusEnum.RegisterStatus.ERROR;
    }
}
