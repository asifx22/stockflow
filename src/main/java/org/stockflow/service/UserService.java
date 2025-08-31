package org.stockflow.service;

import org.stockflow.dto.UserDto;
import org.stockflow.dto.UserItemCountDto;

import java.util.List;

public interface UserService {

    // 🔹 Create
    UserDto saveUser(UserDto userDto);

    // 🔹 Read
    List<UserDto> viewAll();

    UserDto getUser(Long id);

    UserDto getUserByEmail(String email);

    List<UserDto> getUsersByRole(String role); // e.g., "ADMIN", "USER"

    // 🔹 Update
    UserDto updateUser(Long id, UserDto userDto);

    UserDto updatePassword(Long id, String newPassword);

    UserDto toggleActiveStatus(Long id, boolean isActive);

    // 🔹 Delete
    void deleteUser(Long id);

    // 🔹 Utility
    boolean emailExists(String email);

    long countAllUsers();

    List<UserItemCountDto> getUserItemCounts();

}
