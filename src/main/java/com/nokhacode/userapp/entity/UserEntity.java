package com.nokhacode.userapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String password;

    private String firstName;
    private String lastName;

    @CreatedDate
    private Timestamp createdAt;

    private Timestamp modifiedAt;

    @PrePersist
    private void onPrePersist(){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        createdAt = now;
        modifiedAt = now;
    }

    @PreUpdate
    private void onPreUpdate(){
        modifiedAt = new Timestamp(System.currentTimeMillis());
    }
}
