package com.maxi.marketplace.user.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {

    @NotBlank(message = "name is required") @Size(max=100)  private String name;
    @NotBlank(message = "email is required") @Email @Size(max=254) private String email;

    public CreateUserRequest() {}
    public CreateUserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

}