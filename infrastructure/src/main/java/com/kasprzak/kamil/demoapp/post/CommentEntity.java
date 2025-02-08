package com.kasprzak.kamil.demoapp.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Comment")
@Getter
@Setter
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private PostEntity postEntity;

    @Column(name = "CONTENT")
    private String content;

}
