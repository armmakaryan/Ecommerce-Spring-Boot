package com.smartCode.ecommerce.util.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class RegistrationEvent extends ApplicationEvent {

    private final String code;
    private final String email;
    private final Integer userId;

    public RegistrationEvent(Object source, String code, String email, Integer userId) {
        super(source);
        this.code = code;
        this.email = email;
        this.userId = userId;
    }
}
