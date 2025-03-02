package com.kasprzak.kamil.demoapp.notification;

import com.kasprzak.kamil.demoapp.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NOTIFICATIONS", indexes = {
        @Index(name = "idx_notifications_user_id", columnList = "user_id")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @Column(name = "CONTENT", nullable = false, length = 500)
    private String content;
}
