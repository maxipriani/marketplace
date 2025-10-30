package com.maxi.marketplace.user.model;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
        name = "users",
        uniqueConstraints = { @UniqueConstraint(name = "uk_users_email", columnNames = "email") }
)

public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    @Column(nullable = false) private String name;
    @Column(nullable = false) private String email;
    @Column(nullable=false, updatable=false) private Instant createdAt = Instant.now();
    @Column(nullable=false) private Instant updatedAt = Instant.now();

    @PreUpdate void onUpdate(){
        this.updatedAt = Instant.now();
    }

    // @Column(nullable = false)
    // private String passwordHash; // not implemented yet

    public UserEntity() {}
    public UserEntity(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

}