//package org.stockflow.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.stockflow.entity.UserEntity;
//import org.stockflow.repository.UserRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserEntity saveUser(UserEntity user) {
//        return userRepository.save(user);
//    }
//
//    public List<UserEntity> viewAll() {
//        return userRepository.findAll();
//    }
//
//    public Optional<UserEntity> getUser(Long id) {
//        return userRepository.findById(id);
//    }
//}
//
