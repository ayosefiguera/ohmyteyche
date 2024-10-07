package com.ohmytyche.core.user.infrastructure.controllers;

import com.ohmytyche.core.user.application.services.UserService;
import com.ohmytyche.core.user.domain.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(final UserService userService) {
        setUserService(userService);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody final User user) {
        final User createdUser = getUserService().createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable final Long id) {
        return getUserService().getUserById(id)
                .map(User -> new ResponseEntity<>(User, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> UserList = getUserService().getAll();
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable final Long id, @RequestBody final User updateUser) {
        return getUserService().updateUser(updateUser)
                .map(User -> new ResponseEntity<>(User, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable final Long id) {
        // CHECK DELETED whe return a boolean.
        if (getUserService().deleteUser(id)) return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    protected UserService getUserService() {
        return userService;
    }

    public void setUserService(final UserService userService) {
        this.userService = userService;
    }
}
