package com.anapedra.commerce.services;

import com.anapedra.commerce.entities.User;
import com.anapedra.commerce.repositories.UserRepository;
import com.anapedra.commerce.services.exceptionservice.ForbiddenException;
import com.anapedra.commerce.services.exceptionservice.UnauthorizedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional(readOnly = true)
    public User authenticated(){
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.registrationEmail(username);
        }
        catch (Exception e){
            throw new UnauthorizedException("Invalid User!");
        }
    }

    public void validateSelfOrAdmin(Long userId){
        User user=authenticated();
        if (!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }

    }
    public void validateClient(){
        User user=authenticated();
        if (!user.hasHole("ROLE_CLIENT")){
            throw new ForbiddenException("Access denied");
        }
    }
    public void validSelf(Long userId){
        User user=authenticated();
        if (!user.getId().equals(userId)){
            throw new ForbiddenException("Access denied");
        }
    }
    public void validateAdmin(){
        User user=authenticated();
        if (!user.hasHole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }
    }





}









