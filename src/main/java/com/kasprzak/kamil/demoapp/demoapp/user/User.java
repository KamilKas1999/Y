package com.kasprzak.kamil.demoapp.demoapp.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "USERNAME")
    private String username;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }
}
