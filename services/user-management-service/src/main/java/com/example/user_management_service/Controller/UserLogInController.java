package com.example.user_management_service.Controller;


import com.example.user_management_service.DTO.UserLogInDTO;
import com.example.user_management_service.Service.UserLogInService;
import org.springframework.http.ResponseEntity;
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

        if(userLogInService.userLogInCheck(userLogInDTO))
            return ResponseEntity.accepted().body("Success");

        return ResponseEntity.internalServerError().body("Server Crashed");
    }
}
