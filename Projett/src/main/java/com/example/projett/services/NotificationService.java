package com.example.projett.services;

import com.example.projett.entities.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private EmailService emailService;

    public void sendNotification(NotificationRequest request) {
        if ("EMAIL".equalsIgnoreCase(request.getType())) {
            emailService.sendEmail(request.getRecipient(), request.getSubject(), request.getMessage());
        }
        // Additional notification types can be handled here
    }
}
