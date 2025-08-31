package org.stockflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stockflow.dto.UserDto;
import org.stockflow.dto.UserItemCountDto;
import org.stockflow.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // ✨ CHANGE 1: Crucial for allowing Angular to connect
@RequestMapping("api/users") // ✨ CHANGE 2: Standard REST convention (plural)
public class UserController {

    @Autowired
    private UserService userService;

    // 🔹 Create
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.saveUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // 🔹 Get All Users
    @GetMapping
    public ResponseEntity<List<UserDto>> viewUsers() {
        List<UserDto> all = userService.viewAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    // 🔹 Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        UserDto user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // 🔹 Update User
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    // 🔹 Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    // 🔹 Toggle Active Status
    @PatchMapping("/{id}/status")
    public ResponseEntity<UserDto> toggleStatus(@PathVariable Long id, @RequestParam boolean active) {
        UserDto updated = userService.toggleActiveStatus(id, active);
        return ResponseEntity.ok(updated);
    }

    // 🔹 Get by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getByEmail(@PathVariable String email) {
        UserDto user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    // 🔹 Count Users
    @GetMapping("/count")
    public ResponseEntity<Long> countUsers() {
        return ResponseEntity.ok(userService.countAllUsers());
    }

    // 🔹 Check Email Exists
    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> checkEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.emailExists(email));
    }

    @GetMapping("/count-check")
    public ResponseEntity<List<UserItemCountDto>> checkUserItemCount() {
        return ResponseEntity.ok(userService.getUserItemCounts());

    }
}
