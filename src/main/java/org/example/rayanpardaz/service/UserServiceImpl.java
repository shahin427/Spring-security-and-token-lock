package org.example.rayanpardaz.service;

import org.example.rayanpardaz.dao.UserRepository;
import org.example.rayanpardaz.dto.UserDTO;
import org.example.rayanpardaz.security.LoginRequest;
import org.example.rayanpardaz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<UserDTO> getUserList(Pageable pageable) {
        return userRepository.getUserList(pageable);
    }

    @Override
    public User findByUserName(LoginRequest loginRequest) {
        User user = userRepository.findUserByUserName(loginRequest.getUserName());
        if (user != null && user.checkPassword(loginRequest.getPassword())) {
            return user;
        }
        return null;
    }
}
