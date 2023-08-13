package com.smartCode.ecommerce.model.dto.notification;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
public class NotificationDto {

    @NotBlank
    private String title;

    @NotBlank
    private  String content;

    private String description;

    @NotNull
    private LocalDateTime notificationDate;

    @Email
    @NotBlank
    private String  email;

    private Integer userId;
}