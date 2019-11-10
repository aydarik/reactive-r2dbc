package ru.gumerbaev.reactive.server.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.gumerbaev.reactive.server.db.entity.User;
import ru.gumerbaev.reactive.server.service.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final @NonNull UserService service;

    @GetMapping
    public Flux<User> getAll() {
        return service.getAll();
    }
}
