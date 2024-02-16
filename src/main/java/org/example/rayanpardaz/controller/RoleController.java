package org.example.rayanpardaz.controller;

import jakarta.validation.Valid;
import org.example.rayanpardaz.model.Role;
import org.example.rayanpardaz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void saveRole(@Valid @RequestBody Role role) {
        roleService.saveRole(role);
    }
}
