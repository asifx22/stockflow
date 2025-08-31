package org.stockflow.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stockflow.dto.UserDto;
import org.stockflow.dto.UserItemCountDto;
import org.stockflow.entity.UserEntity;
import org.stockflow.enums.UserRole;
import org.stockflow.mapper.UserMapper;
import org.stockflow.repository.UserRepository;
import org.stockflow.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    // 🔹 Create
    @Override
    public UserDto saveUser(UserDto userDto) {
        UserEntity entity = UserMapper.toEntity(userDto);
//        if (userDto.getOwnerId() != null) {
//            UserEntity owner = userRepository.findById(userDto.getOwnerId())
//                    .orElseThrow(() -> new RuntimeException("Owner not found"));
//            entity.setOwner(owner);
//        }
        UserEntity saved = userRepository.save(entity);
        return UserMapper.toDto(saved);
    }

    // 🔹 Read
    @Override
    public List<UserDto> viewAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        return UserMapper.toDto(entity);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserEntity entity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return UserMapper.toDto(entity);
    }

    @Override
    public List<UserDto> getUsersByRole(String role) {
        UserRole userRole = UserRole.valueOf(role.toUpperCase());
        return userRepository.findByRole(userRole)
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    // 🔹 Update
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setFirstname(userDto.getFirstname());
        existing.setLastname(userDto.getLastname());
        existing.setUsername(userDto.getUsername());
        existing.setEmail(userDto.getEmail());
        existing.setAddress(userDto.getAddress());
        existing.setActive(userDto.isActive());
        existing.setAdmin(userDto.isAdmin());
        existing.setRole(userDto.getRole());

        UserEntity updated = userRepository.save(existing);
        return UserMapper.toDto(updated);
    }

    @Override
    public UserDto updatePassword(Long id, String newPassword) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(newPassword); // 🔐 You may hash it here
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto toggleActiveStatus(Long id, boolean isActive) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(isActive);
        return UserMapper.toDto(userRepository.save(user));
    }

    // 🔹 Delete
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // 🔹 Utility
    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public long countAllUsers() {
        return userRepository.count();
    }

    @Override
    public List<UserItemCountDto> getUserItemCounts() {

        return userRepository.getUserItemCounts();
    }
}
