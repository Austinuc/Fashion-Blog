package com.week9.week_nine_sq012austinuc.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String role;

    private String firstName;
    private String lastName;
    private String password;

    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
}
