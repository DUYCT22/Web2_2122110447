package com.nguyennhutduy.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private int role;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = true, unique = false)
    private String image;

    @Column(nullable = false, unique = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false, unique = false)
    private int status;

    @Column(nullable = false, unique = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }

}
