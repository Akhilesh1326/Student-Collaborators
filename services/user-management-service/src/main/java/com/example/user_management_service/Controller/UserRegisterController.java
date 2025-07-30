package com.example.user_management_service.Controller;


import com.example.user_management_service.DTO.UserRegisterDTO;
import com.example.user_management_service.Enums.RegistrationStatusEnum;
import com.example.user_management_service.Service.UserRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user-management-service/register-service")
public class UserRegisterController {
    UserRegisterService userRegisterService;

    public UserRegisterController(UserRegisterService userRegisterService){
        this.userRegisterService = userRegisterService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> handleRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        if(userRegisterDTO.getEmail() == null || userRegisterDTO.getCollegeName() == null || userRegisterDTO.getFirstName() == null || userRegisterDTO.getLastName() == null || userRegisterDTO.getPassword() == null || userRegisterDTO.getUsername() == null) {
            return ResponseEntity.badRequest().body("Required fields are empty");
        }
        RegistrationStatusEnum.RegisterStatus status = userRegisterService.createNewUser(userRegisterDTO);

        return switch (status) {
            case SUCCESS -> ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
            case EMAIL_EXISTS -> ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use.");
            case USERNAME_EXISTS -> ResponseEntity.status(HttpStatus.CONFLICT).body("Username already in use.");
            default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        };
    }
}
