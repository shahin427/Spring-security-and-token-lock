package org.example.rayanpardaz.controller;

import jakarta.websocket.server.PathParam;
import org.example.rayanpardaz.dto.UserDTO;
import org.example.rayanpardaz.model.User;
import org.example.rayanpardaz.tokenLock.TokenLock;
import org.example.rayanpardaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/user-list")
    public Page<UserDTO> getUserList(Pageable pageable) {
        return userService.getUserList(pageable);
    }


}
