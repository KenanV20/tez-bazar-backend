package com.ads.advertisement.dao.entity;

import com.ads.advertisement.dao.entity.Products.ProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", length = 64)
    private String fullName;

    @Column(length = 64)
    private String email;

    @Column(name = "avatar_link")
    private String avatarLink;

    @Column(name = "phone_number_one", length = 32)
    private String phoneNumberOne;

    @Column(name = "phone_number_two", length = 32)
    private String phoneNumberTwo;

    @OneToMany(mappedBy = "userEntity")
    private List<ProductsEntity> productsEntities;

    private String password;

    private Float count;

    @Column(length = 16)
    private String gender;
    @Column(name = "is_active")
    private Boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
