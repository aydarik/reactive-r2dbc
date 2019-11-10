package ru.gumerbaev.reactive.client;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gumerbaev.reactive.client.entity.User;
import ru.gumerbaev.reactive.client.webclient.UserWebClient;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    private final @NonNull UserWebClient userClient;

    @Override
    public void run(String... args) {
//        final User testUser = new User("Client", "Web", "client.web@acme.com");
//        userClient.save(testUser).log().subscribe(
//                res -> log.info("Saved"),
//                err -> log.error("Save error", err),
//                () -> log.info("Save complete"));

        userClient.getAll().take(5).log().subscribe(
                u -> log.info("Time: {}, User: {}", System.currentTimeMillis(), u),
                err -> log.error("Receive error", err),
                () -> log.info("Receive done")).dispose();

        log.info("Finished");
    }
}
