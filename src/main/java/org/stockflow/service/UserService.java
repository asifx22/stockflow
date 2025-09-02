package org.stockflow.service;

import org.springframework.data.domain.Page;
import org.stockflow.dto.UserDto;
import org.stockflow.dto.UserItemCountDto;

import java.util.List;

public interface UserService {

    // 🔹 Create
    UserDto saveUser(UserDto userDto);

    // 🔹 Read
    Page<UserDto> viewAll(String pageNo, String pageSize);

    List<UserDto> getAll();

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
