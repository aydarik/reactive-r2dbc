package ru.gumerbaev.reactive.server.db.repository;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.gumerbaev.reactive.server.db.entity.User;

public interface ReactiveUserRepository extends ReactiveCrudRepository<User, Integer> {

    @Query("SELECT * FROM users WHERE email = :email")
    Mono<User> findByEmail(String email);
}