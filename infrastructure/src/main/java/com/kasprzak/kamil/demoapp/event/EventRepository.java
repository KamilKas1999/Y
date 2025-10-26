package com.kasprzak.kamil.demoapp.event;

import com.kasprzak.kamil.demoapp.notification.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity,Long> {

    List<EventEntity> findByUserId(Long userId);


}
