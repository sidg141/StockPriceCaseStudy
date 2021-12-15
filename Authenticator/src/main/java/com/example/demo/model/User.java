package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "confirmed")
    private boolean confirmed;
}
