package com.kasprzak.kamil.demoapp.notification.service;

import com.kasprzak.kamil.demoapp.notification.NotificationEntity;

import java.util.List;

public interface NotificationService{

    void createNotification(Long userId, String topic, String content);

    List<NotificationEntity> getNotifications(final Long userId);
}
