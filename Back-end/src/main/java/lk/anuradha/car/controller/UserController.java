package lk.anuradha.car.controller;

import lk.anuradha.car.dto.UserDTO;
import lk.anuradha.car.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("login")
    public boolean canAuthenticate(@RequestBody UserDTO user) {
        return userService.canAuthenticate(user.getUsername(), user.getPassword());
    }
}
