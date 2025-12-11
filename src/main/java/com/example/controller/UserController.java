package com.example.controller;



import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ FIND ALL USERS
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // ✅ GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new RuntimeException("User not found"));
    //            .orElse(ResponseEntity.badRequest().body("User not found"));
    }

    // ✅ GET USER BY EMAIL
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // ✅ UPDATE USER BY EMAIL
    @PutMapping("/email/{email}")
    public ResponseEntity<?> updateUserByEmail(
            @PathVariable String email,
            @RequestBody User updatedUser
    ) {
        User updated = userService.updateUserByEmail(email, updatedUser);

        if (updated == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("❌ User not found!");
        }

        userRepository.deleteById(id);

        return ResponseEntity.ok("✅ User deleted successfully!");
    }

}
