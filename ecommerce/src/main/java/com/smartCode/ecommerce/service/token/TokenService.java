package com.smartCode.ecommerce.service.token;

import com.smartCode.ecommerce.model.entity.token.TokenEntity;

public interface TokenService {
    TokenEntity findTokenEntityByToken(String token);

    void saveToken(TokenEntity tokenEntity);

    TokenEntity findTokenEntityByUserId(Integer id);

    void deleteToken(Integer id, String token);
}