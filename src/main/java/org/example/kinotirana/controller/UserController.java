package org.example.kinotirana.controller;

import jakarta.validation.Valid;
import org.example.kinotirana.entity.User;
import org.example.kinotirana.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/përdorues")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return userService.create(user);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @Valid @RequestBody User user) {
        return userService.update(id, user);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}