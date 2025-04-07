package com.nguyennhutduy.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, unique = true)
    public String name;

    @Column(nullable = false, unique = false)
    public char size;

    @Column(nullable = false, unique = false)
    public String color;

    @Column(nullable = false, unique = false)
    public String detail;

    @Column(nullable = false, unique = true)
    public String slug;

    @Column(nullable = false, unique = false)
    public double importPrice;

    @Column(nullable = false, unique = false)
    public double sellingPrice;

    @Column(nullable = false, unique = false)
    public double discountPrice;

    @Column(nullable = false, unique = false)
    public int quantity;

    @Column(nullable = false, unique = false)
    public int sold;

    @Column(nullable = false, unique = false)
    public int status;

    @Column(nullable = false, unique = false)
    private LocalDate createdAt;

    @Column(nullable = false, unique = false)
    private int createdBy;

    @Column(nullable = true, unique = false)
    private LocalDate updatedAt;

    @Column(nullable = true, unique = false)
    private int updatedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDate.now();
    }

}
