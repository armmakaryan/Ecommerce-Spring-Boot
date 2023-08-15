package com.smartCode.ecommerce.service.notification.impl;

import com.smartCode.ecommerce.feign.NotificationFeignClient;
import com.smartCode.ecommerce.model.dto.notification.CreateNotificationDto;
import com.smartCode.ecommerce.model.dto.notification.NotificationDto;
import com.smartCode.ecommerce.model.dto.notification.ResponseNotificationDto;
import com.smartCode.ecommerce.service.notification.NotificationService;
import com.smartCode.ecommerce.util.constants.Message;
import com.smartCode.ecommerce.util.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationFeignClient notificationFeignClient;

    @Override
    @Transactional
    public ResponseNotificationDto create(CreateNotificationDto notificationDto) {
        notificationDto.setUserId(CurrentUser.getId());
        return notificationFeignClient.create(notificationDto).getBody();
    }

    @Override
    @Transactional
    public void createForRegistration(String code, Integer userId, String email) {
        NotificationDto notificationRequestDto = new NotificationDto();
        notificationRequestDto.setTitle(Message.EMAIL_SUBJECT);
        notificationRequestDto.setContent(Message.EMAIL_MESSAGE + code);
        notificationRequestDto.setEmail(email);
        notificationRequestDto.setUserId(userId);

        notificationFeignClient.sendVerificationCode(notificationRequestDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseNotificationDto> getReady() {
        return notificationFeignClient.getReady(CurrentUser.getId()).getBody();
    }
    @Override
    @Transactional(readOnly = true)
    public List<ResponseNotificationDto> getWaiting() {
        return notificationFeignClient.getSent(CurrentUser.getId()).getBody();
    }
}