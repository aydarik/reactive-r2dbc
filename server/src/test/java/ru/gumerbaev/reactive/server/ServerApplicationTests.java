package ru.gumerbaev.reactive.server;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gumerbaev.reactive.server.db.entity.User;
import ru.gumerbaev.reactive.server.service.UserService;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
@RequiredArgsConstructor
class ServerApplicationTests {

    private @NonNull UserService userService;

/*
    @Test
    void flux() {
        final Flux<Integer> ints = Flux.create(sink -> {
            try {
                sink.next(1);
                Thread.sleep(1000);
                sink.next(2);
                sink.complete();
            } catch (InterruptedException e) {
                sink.error(e);
            }
        });

        ints.subscribe(i -> log.info("Number: {}", i),
                err -> log.error("Error", err),
                () -> log.info("Done"));
    }
*/

    @Test
    void db_flux() {
        userService.getAll().take(5).log().subscribe(
                u -> log.info("Time: {}, User: {}", System.currentTimeMillis(), u),
                err -> log.error("Receive error", err),
                () -> log.info("Receive done"));
    }

/*
    @Test
    void db() {
        final User testUser = new User("User", "Test", "user.test@acme.com");
        userService.findByEmail(testUser.getEmail()).as(StepVerifier::create)
                .expectNextCount(1).verifyComplete();
    }
*/
}
