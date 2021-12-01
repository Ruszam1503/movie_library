package com.example.movie_library.validator;

import com.example.movie_library.model.User;
import com.example.movie_library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValid implements Validator {

    private final UserService userService;

    @Autowired
    public UserValid(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object userValid, Errors errors) {
        User user = (User) userValid;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.not_empty");

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "register.error.diff_password");
        }

        if (userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "register.error.duplicated.email");
        }
    }
}