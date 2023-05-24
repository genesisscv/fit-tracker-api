package org.example.controller;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        // Logic for handling the login page

        // Example logic: Initialize a new User object
        User user = new User();

        // Create a new ModelAndView object
        ModelAndView modelAndView = new ModelAndView("login"); // Assuming you have a login.html template

        // Set the user object as a model attribute
        modelAndView.addObject("user", user);

        return modelAndView;

    }

    @PostMapping("/login")
    public ModelAndView processLogin(String username) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", username);
        modelAndView.setViewName("redirect:/dashboard");
        return modelAndView;
    }

    @PostMapping("/create")
    public String createUser(String username) {
        // Create a new User instance
        User user = new User();
        user.setUsername(username);


        // Save the user to the database
        userRepository.save(user);

        return "redirect:/user/login";
    }
}
