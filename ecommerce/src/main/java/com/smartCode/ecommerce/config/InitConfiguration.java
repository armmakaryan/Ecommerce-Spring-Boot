package com.smartCode.ecommerce.config;

import com.smartCode.ecommerce.model.entity.role.RoleEntity;
import com.smartCode.ecommerce.repository.role.RoleRepository;
import com.smartCode.ecommerce.util.constants.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class InitConfiguration {
    private final RoleRepository roleRepository;

    @PostConstruct
    @Transactional
    public void setupDB() {
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