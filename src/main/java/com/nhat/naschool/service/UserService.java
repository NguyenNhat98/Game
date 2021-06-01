package com.nhat.naschool.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.nhat.naschool.dto.UserRegistrationDto;
import com.nhat.naschool.entity.User;




@Service
public interface UserService extends UserDetailsService{
   

    User save(UserRegistrationDto registration);

}
