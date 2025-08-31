package org.stockflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.stockflow.dto.UserItemCountDto;
import org.stockflow.entity.UserEntity;
import org.stockflow.enums.UserRole;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findByRole(UserRole role);

    boolean existsByEmail(String email);

    @Query("SELECT new org.stockflow.dto.UserItemCountDto(u.id, u.username, COUNT(s)) " +
            "FROM UserEntity u LEFT JOIN StockItem s ON s.owner.id = u.id " +
            "GROUP BY u.id, u.username")
    List<UserItemCountDto> getUserItemCounts();
}
