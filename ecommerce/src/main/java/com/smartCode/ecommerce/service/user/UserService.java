package com.smartCode.ecommerce.service.user;

import com.smartCode.ecommerce.model.dto.user.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    ResponseUserDto register(CreateUserDto user);

    List<ResponseUserDto> getAllUsers();

    ResponseUserDto getById(Integer id);

    ResponseUserDto verify(Integer id, String code);

    ResponseUserDto updatePartially(Integer id, PartialUpdateUserDto updatedUser);

    UserAuthDto login(String email, String password);

    ResponseUserDto delete(Integer id);

    ResponseUserDto updateUser(Integer id, UpdateUserDto updatedUser);

    ResponseUserDto changePassword(Integer id, ChangePasswordUserDto dto);

    void logout(String token);

//    List<ResponseUserDto> search(FilterSearchUser.Search userSearch);
//
//    List<ResponseUserDto> filter(FilterSearchUser.Filter userFilter);
}