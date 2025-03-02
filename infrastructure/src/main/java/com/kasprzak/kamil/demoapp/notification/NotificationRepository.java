package com.kasprzak.kamil.demoapp.notification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<NotificationEntity,Long> {

    List<NotificationEntity> findByUserId(Long userId);


}
