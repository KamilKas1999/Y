package com.kasprzak.kamil.demoapp.post;

import com.kasprzak.kamil.demoapp.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "POSTS")
@Getter
@Setter
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    private UserEntity userEntity;

    @Column(name = "CONTENT")
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> commentEntities;

    public PostEntity(UserEntity userEntity, String content) {
        this.userEntity = userEntity;
        this.content = content;
    }
}
