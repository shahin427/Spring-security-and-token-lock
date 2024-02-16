package org.example.rayanpardaz.dao;

import org.example.rayanpardaz.dto.UserDTO;
import org.example.rayanpardaz.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT new org.example.rayanpardaz.dto.UserDTO(u.id, u.name, u.familyName, r.name) FROM User u join u.role r")
    Page<UserDTO> getUserList(Pageable pageable);

    User findUserByUserName(String userName);
}
