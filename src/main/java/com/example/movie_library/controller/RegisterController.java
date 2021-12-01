package com.example.movie_library.controller;

import com.example.movie_library.model.User;
import com.example.movie_library.service.UserService;
import com.example.movie_library.validator.UserValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;
    private final UserValid userValid;

@Autowired
    public RegisterController(UserService userService, UserValid userValid) {
        this.userService = userService;
        this.userValid = userValid;
    }

    @GetMapping("/register")
    public String userRegister(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
    userValid.validate(userForm,bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.save(userForm);
        userService.login(userForm.getName(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }
}
