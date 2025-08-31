package org.stockflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.stockflow.enums.UserRole;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_user")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "isactive")
    private boolean isActive = true;


    @Column(name = "isadmin")
    private boolean isAdmin;

    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;


    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "createdby")
    private String createdby;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Column(name = "updatedby")
    private String updatedby;



    @PrePersist
    protected void onCreate() {
        this.created = LocalDateTime.now();
    }
}
