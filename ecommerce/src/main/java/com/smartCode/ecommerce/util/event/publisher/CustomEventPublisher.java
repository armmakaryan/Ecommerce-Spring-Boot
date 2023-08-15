package com.smartCode.ecommerce.util.event.publisher;

import com.smartCode.ecommerce.model.entity.user.UserEntity;
import com.smartCode.ecommerce.util.event.RegistrationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishRegistrationEvent(UserEntity userEntity) {
        RegistrationEvent registrationEvent = new RegistrationEvent(this, userEntity.getCode(), userEntity.getEmail(), userEntity.getId());
        applicationEventPublisher.publishEvent(registrationEvent);
    }

}
