package com.example.user_management_service.Service;


import com.example.user_management_service.DTO.UserLogInDTO;
import com.example.user_management_service.Repo.UserLoginRepository;
import com.example.user_management_service.Repo.UserRegisterRepository;
import org.springframework.stereotype.Service;

@Service
public class UserLogInService {

    private UserLoginRepository userLoginRepository;
    public UserLogInService(UserLoginRepository userLoginRepository){
        this.userLoginRepository = userLoginRepository;
    }
    public boolean userLogInCheck(UserLogInDTO userLogInDTO) {
        if(userLoginRepository.existsUsername(userLogInDTO.getUsername()) && userLoginRepository.existsPasswordHash(userLogInDTO.getPassword())) {
            return true;
        }
        return false;
    }
}
