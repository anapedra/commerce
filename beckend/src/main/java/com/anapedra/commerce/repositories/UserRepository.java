package com.anapedra.commerce.repositories;

import com.anapedra.commerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User registrationEmail(String name);

}
