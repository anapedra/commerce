package com.anapedra.commerce.services;


import com.anapedra.commerce.dtos.*;
import com.anapedra.commerce.entities.Role;
import com.anapedra.commerce.entities.User;
import com.anapedra.commerce.repositories.RoleRepository;
import com.anapedra.commerce.repositories.UserRepository;
import com.anapedra.commerce.services.exceptionservice.DataBaseException;
import com.anapedra.commerce.services.exceptionservice.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private static Logger logger=  LoggerFactory.getLogger(UserService.class);
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthService authService;


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }


    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable){
        Page<User> list=userRepository.findAll(pageable);
        authService.validateAdmin();
        return list.map(x -> new UserDTO(x));
    }
    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        Optional<User> obj=userRepository.findById(id);
         authService.validateSelfOrAdmin(id);
        User entity=obj.orElseThrow(
                ()-> new ResourceNotFoundException("Id "+id+" not found"));
        return new UserDTO(entity);
    }

    @Transactional

    public UserDTO insert(UserInsertDTO dto) {
        var user=new User();
        copyDtoToEntity(dto,user);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user=userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserUpdateDTO userDTO){
        authService.validateAdmin();
        try {
            var user= userRepository.getOne(id);
            copyDtoToEntity(userDTO,user);
            user=userRepository.save(user);
            return new UserDTO(user);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id " + id + " not found :(");
        }
    }

    @Transactional
    public void deleteById(Long id){
        authService.validateAdmin();
        try {
            userRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id "+id+" not found!");
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrity violation");
        }

    }

    private void copyDtoToEntity(UserDTO userDTO,User entity){
        entity.setRegistrationEmail(userDTO.getRegistrationEmail());
        entity.setCpf(userDTO.getCpf());
        entity.setMainPhone(userDTO.getMainPhone());
        entity.setMomentRegistration(Instant.now());
        entity.setMomentUpdate(Instant.now());
        entity.setRegistrationEmail(userDTO.getRegistrationEmail());
        entity.setName(userDTO.getName());


        entity.getRoles().clear();
        for (RoleDTO roleDTO : userDTO.getRoles()){
            Role role=roleRepository.getOne(roleDTO.getId());
            entity.getRoles().add(role);
        }

    }
    @Transactional(readOnly = true)
    public UserDTO getProfile() {
        return new UserDTO(authService.authenticated());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.registrationEmail(username);
        if (user == null){
            logger.error("User not found: "+username);
            throw new UsernameNotFoundException("Email not found!");
        }
        logger.info("User found!"+username);
        return  user;
    }


}









