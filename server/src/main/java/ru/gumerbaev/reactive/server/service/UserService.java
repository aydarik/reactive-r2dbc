package ru.gumerbaev.reactive.server.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.gumerbaev.reactive.server.db.entity.User;
import ru.gumerbaev.reactive.server.db.repository.ReactiveUserRepository;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final @NonNull ReactiveUserRepository repository;

    public Mono<User> save(User user) {
        return repository.save(user);
    }

    public Flux<User> getAll() {
        log.warn("All contacts request received");
        return repository.findAll();
    }

    public Mono<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Mono<Void> delete(User user) {
        return repository.delete(user);
    }
}
