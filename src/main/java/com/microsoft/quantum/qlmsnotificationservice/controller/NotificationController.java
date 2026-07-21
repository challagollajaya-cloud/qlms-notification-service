package com.microsoft.quantum.qlmsnotificationservice.controller;

import com.microsoft.quantum.qlmsnotificationservice.model.Notification;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private List<Notification> notifications = new ArrayList<>();

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notifications;
    }

    @PostMapping("/send")
    public Notification sendNotification(
            @RequestBody Notification notification) {
        notification.setId(UUID.randomUUID().toString());
        notification.setStatus("SENT");
        notification.setCreatedAt(LocalDateTime.now());
        notifications.add(notification);
        System.out.println("Notification sent to: "
                + notification.getRecipient()
                + " Message: " + notification.getMessage());
        return notification;
    }

    @PostMapping("/calibration-reminder")
    public Notification sendCalibrationReminder(
            @RequestParam String equipmentName,
            @RequestParam String labManager,
            @RequestParam int daysUntilDue) {
        Notification notification = Notification.builder()
                .id(UUID.randomUUID().toString())
                .type("CALIBRATION_REMINDER")
                .message("Equipment " + equipmentName
                        + " calibration due in "
                        + daysUntilDue + " days!")
                .recipient(labManager)
                .status("SENT")
                .createdAt(LocalDateTime.now())
                .build();
        notifications.add(notification);
        System.out.println("Calibration reminder sent: "
                + notification.getMessage());
        return notification;
    }

    @PostMapping("/shipment-update")
    public Notification sendShipmentUpdate(
            @RequestParam String shipmentNumber,
            @RequestParam String status,
            @RequestParam String recipient) {
        Notification notification = Notification.builder()
                .id(UUID.randomUUID().toString())
                .type("SHIPMENT_UPDATE")
                .message("Shipment " + shipmentNumber
                        + " status updated to: " + status)
                .recipient(recipient)
                .status("SENT")
                .createdAt(LocalDateTime.now())
                .build();
        notifications.add(notification);
        System.out.println("Shipment update sent: "
                + notification.getMessage());
        return notification;
    }
}