package com.kasprzak.kamil.demoapp.notification.service;

import com.kasprzak.kamil.demoapp.notification.NotificationEntity;
import com.kasprzak.kamil.demoapp.notification.NotificationRepository;
import com.kasprzak.kamil.demoapp.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultNotificationService implements NotificationService{

    private final NotificationRepository notificationRepository;

    private final UserRepository userRepository;

    public void createNotification(Long userId, String topic, String content) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        NotificationEntity entity = NotificationEntity
                .builder()
                .user(user)
                .topic(topic)
                .content(content)
                .build();

        notificationRepository.save(entity);
    }


    public List<NotificationEntity> getNotifications(final Long userId){
        return notificationRepository.findByUserId(userId);
    }

}
