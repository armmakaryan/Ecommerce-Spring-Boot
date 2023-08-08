package com.smartCode.ecommerce.model.entity.token;

import com.smartCode.ecommerce.model.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tokens")
public class TokenEntity {
    @Id
    private Integer id;

    @Column(nullable = false,unique = true)
    private String token;

    @OneToOne(optional = false)
    @MapsId
    private UserEntity user;

}