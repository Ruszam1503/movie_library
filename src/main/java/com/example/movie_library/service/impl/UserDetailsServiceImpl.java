package com.example.movie_library.service.impl;

import com.example.movie_library.model.User;
import com.example.movie_library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

@Autowired
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);

        if (user != null) {
            return new  MyUserDetails(user);

         //   return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
        }else{
            throw new UsernameNotFoundException("User " + username + " not found!");
        }
    }
    }
