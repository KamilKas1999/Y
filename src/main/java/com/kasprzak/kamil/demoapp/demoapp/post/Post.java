package com.kasprzak.kamil.demoapp.demoapp.post;

import com.kasprzak.kamil.demoapp.demoapp.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user;

    @Column(name = "CONTENT")
    private String content;

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
    }
}
