package com.maxi.marketplace.user.controller;

import com.maxi.marketplace.user.dto.CreateUserRequest;
import com.maxi.marketplace.user.dto.UserResponse;
import com.maxi.marketplace.user.model.UserEntity;
import com.maxi.marketplace.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    public UserController(UserService s) {
        this.service = s;
    }

    @GetMapping // GET /users
    public List<UserResponse> list() {
        return service.list().stream().map(UserController::toDto).toList();
    }

    @GetMapping("/{id}") // GET /users/{id}
    public UserResponse get(@PathVariable Long id) {
        return toDto(service.getOrThrow(id));
    }

    @PostMapping // POST /users
    @ResponseStatus(HttpStatus.CREATED) // 201
    public UserResponse create(@Valid @RequestBody CreateUserRequest req) {
        UserEntity saved = service.create(req.getName(), req.getEmail());
        return toDto(saved);
    }

    @DeleteMapping("/{id}") // DELETE /users/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private static UserResponse toDto(UserEntity e) {
        return new UserResponse(e.getId(), e.getName(), e.getEmail());
    }
}
