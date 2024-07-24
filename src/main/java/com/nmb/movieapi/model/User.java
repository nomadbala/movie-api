package com.nmb.movieapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users2")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String avatarUri;
    private String creditCardNumber;
    private String creditCardExpiryDate;
    private String creditCardCvv;
}