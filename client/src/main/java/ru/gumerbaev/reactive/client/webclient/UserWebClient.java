package ru.gumerbaev.reactive.client.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.gumerbaev.reactive.client.entity.User;

@Component
public class UserWebClient {

    private WebClient client = WebClient.create("http://localhost:8585");

    public Flux<User> getAll() {
        return client.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(User.class);
    }
}
