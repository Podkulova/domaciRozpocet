package org.example.domacirozpocet2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.example.domacirozpocet2.dto.UserRequest;
import org.example.domacirozpocet2.entity.User;
import org.example.domacirozpocet2.exception.UsersNotFoundExeption;
import org.example.domacirozpocet2.service.implementaion.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/")
    public String index(Model model) {
        return "login"; // returns login.html
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // returns login.html
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserRequest user = new UserRequest();
        model.addAttribute("user", user);
        return "register";
    }

    /*@GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable @NotNull @NotEmpty Long id) throws UsersNotFoundExeption {
        return ResponseEntity.ok(service.getUser(id));
    }
    */
}

