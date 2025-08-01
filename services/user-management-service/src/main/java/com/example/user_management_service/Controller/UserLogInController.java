package com.example.user_management_service.Controller;


import com.example.user_management_service.DTO.UserLogInDTO;
import com.example.user_management_service.Enums.RegistrationStatusEnum;
import com.example.user_management_service.Service.UserLogInService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user-management-service/log-in-service")
public class UserLogInController {

    public UserLogInService userLogInService;
    public UserLogInController(UserLogInService userLogInService){
        this.userLogInService = userLogInService;
    }


    @GetMapping("/greet")
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Hey, from user management service");
    }

    @PostMapping("/username-login")
    public ResponseEntity<String> handleUsernameLogIn(@RequestBody UserLogInDTO userLogInDTO){
        if(userLogInDTO.getUsername() == null || userLogInDTO.getPassword() == null){
            return ResponseEntity.badRequest().body("Wrong Credentials");
        }

        RegistrationStatusEnum.RegisterStatus status = userLogInService.userLogInCheck(userLogInDTO);
        return switch (status) {
            case SUCCESS -> ResponseEntity.status(HttpStatus.ACCEPTED).body("User Logged In successfully.");
            case NOT_FOUND -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        };
    }
}
