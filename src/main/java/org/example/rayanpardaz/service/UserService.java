package org.example.rayanpardaz.service;

import org.example.rayanpardaz.dto.UserDTO;
import org.example.rayanpardaz.security.LoginRequest;
import org.example.rayanpardaz.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void saveUser(User user);

    Page<UserDTO> getUserList(Pageable pageable);

    User findByUserName(LoginRequest loginRequest);
}
