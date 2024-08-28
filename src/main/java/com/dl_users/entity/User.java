package com.dl_users.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "app_User")
@Data
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isActive;

    @Column
    private String created;

    @Column
    private String modified;

    @Column
    private String lastLogin;

    @Column
    private String token;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Phone> phones;

    @PrePersist
    protected void onCreate() {
        this.created = LocalDateTime.now().toString();
        this.modified = LocalDateTime.now().toString();
        this.lastLogin= LocalDateTime.now().toString();
        this.isActive= true;

    }

    @PreUpdate
    protected void onUpdate() {
        this.modified = LocalDateTime.now().toString();
    }


}