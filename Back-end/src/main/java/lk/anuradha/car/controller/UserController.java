package lk.anuradha.car.controller;

import lk.anuradha.car.dto.UserDTO;
import lk.anuradha.car.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostMapping("login")
    public boolean canAuthenticate(@RequestBody UserDTO user) {
        return userService.canAuthenticate(user.getUsername(), user.getPassword());
    }
}
