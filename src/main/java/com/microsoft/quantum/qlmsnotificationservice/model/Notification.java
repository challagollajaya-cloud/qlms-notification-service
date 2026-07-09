package com.microsoft.quantum.qlmsnotificationservice.model;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    private String id;
    private String type;
    private String message;
    private String recipient;
    private String status;
    private LocalDateTime createdAt;
}