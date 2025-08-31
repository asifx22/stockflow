package org.stockflow.mapper;

import org.stockflow.dto.UserDto;
import org.stockflow.entity.UserEntity;

public class UserMapper {

    public static UserDto toDto(UserEntity entity) {
        if (entity == null) return null;

        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setActive(entity.isActive());
        dto.setAdmin(entity.isAdmin());
        dto.setAddress(entity.getAddress());
        dto.setRole(entity.getRole());
//        dto.setPassword(entity.getPassword());
//        if (entity.getOwner() != null) {
//            dto.setOwnerId(entity.getOwner().getId());
//            dto.setOwnerName(entity.getOwner().getFirstname() + " " + entity.getOwner().getLastname());
//        }
        return dto;
    }

    public static UserEntity toEntity(UserDto dto) {
        if (dto == null) return null;

        UserEntity entity = new UserEntity();
        if (dto.getId() != null) {
            entity.setId(dto.getId()); // or dto.getId().longValue() if needed
        }
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setActive(dto.isActive());
        entity.setAdmin(dto.isAdmin());
        entity.setAddress(dto.getAddress());
        entity.setRole(dto.getRole());
        entity.setPassword(dto.getPassword());
//        entity.setOwner(entity);
        return entity;
    }
}
