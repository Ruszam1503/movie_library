package com.example.movie_library.service.impl;
import com.example.movie_library.model.User;
import com.example.movie_library.repository.UserRepository;
import com.example.movie_library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

@Autowired
    public UserServiceImpl(UserRepository userRepository, UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder1) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder1;
}

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void update(Long id, User user) {
        User userFromDb = userRepository.findById(id).get();
        userFromDb.setId(id);
        userRepository.save(userFromDb);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Integer getUsersCount() {
        return userRepository.findAll().size();
    }


    @Override
    public User findByName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void login(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(token);

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
        }
    }
}

