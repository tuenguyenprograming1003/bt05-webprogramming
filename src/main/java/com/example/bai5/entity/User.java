package com.example.bai5.legacy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // legacy placeholder

    // ...legacy entity placeholder to avoid conflicts

}
