package com.smartCode.ecommerce.config;

import com.smartCode.ecommerce.model.entity.role.RoleEntity;
import com.smartCode.ecommerce.model.entity.user.UserEntity;
import com.smartCode.ecommerce.repository.role.RoleRepository;
import com.smartCode.ecommerce.repository.user.UserRepository;
import com.smartCode.ecommerce.util.constants.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

import static com.smartCode.ecommerce.util.constants.Gender.MALE;

@Configuration
@RequiredArgsConstructor
public class InitConfiguration {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostConstruct
    @Transactional
    public void setupDB() {
        createRoles();
        createAdmin();
    }

    private void createAdmin() {
        UserEntity user = new UserEntity();
        user.setName("Armen");
        user.setLastname("Makaryan");
        user.setDayOfBirth(LocalDate.ofEpochDay(2002 - 01 - 19));
        user.setUsername("armmakaryan");
        user.setPhone("+37491177578");
        user.setEmail("armmakar7@gmail.com");
        user.setPassword(passwordEncoder.encode("45fbb8c650"));
//        user.setGender(Role.ROLE_ADMIN);
        user.setAge(21);
        userRepository.save(user);
    }

    private void createRoles() {
        if (!roleRepository.existsByRole(Role.ROLE_ADMIN)) {
            RoleEntity admin = new RoleEntity();
            admin.setRole(Role.ROLE_ADMIN);
            roleRepository.save(admin);
        }
        if (!roleRepository.existsByRole(Role.ROLE_USER)) {
            RoleEntity user = new RoleEntity();
            user.setRole(Role.ROLE_USER);
            roleRepository.save(user);
        }
    }
}