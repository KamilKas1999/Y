package com.kasprzak.kamil.demoapp.event;

import com.kasprzak.kamil.demoapp.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EVENT")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class EventEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;

    @Column(name = "CONTENT", nullable = false, length = 500)
    private String content;


}
