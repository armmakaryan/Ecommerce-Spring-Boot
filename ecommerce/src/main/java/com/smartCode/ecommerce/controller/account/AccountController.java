package com.smartCode.ecommerce.controller.account;

import com.smartCode.ecommerce.model.dto.user.CreateUserDto;
import com.smartCode.ecommerce.model.dto.user.ResponseUserDto;
import com.smartCode.ecommerce.model.dto.user.UserAuthDto;
import com.smartCode.ecommerce.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@RestController
@RequiredArgsConstructor
@Validated
public class AccountController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseUserDto> register(@RequestBody @Valid CreateUserDto user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/verify/{id}")
    public ResponseEntity<ResponseUserDto> verify(@PathVariable @Positive Integer id,
                                                  @RequestParam @NotBlank @Size(min = 6, max = 6) String code) {
        return ResponseEntity.ok(userService.verify(id, code));
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthDto> loginUser(@RequestParam @NotBlank String username,
                                                 @RequestParam @NotBlank @Size(min = 8) String password) {
        return ResponseEntity.ok(userService.login(username, password));
    }

    @GetMapping("/aaa/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
        userService.logout(token);
        return ResponseEntity.ok().build();
    }


}