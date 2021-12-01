package com.example.movie_library.repository;

import com.example.movie_library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String username);
    User findByEmail(String email);
}
