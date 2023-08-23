package ru.max.learn.springwebfluxlearn.representation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.max.learn.springwebfluxlearn.domain.Client;

@Slf4j
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientsController {

    private final WebClient webClient;

    @GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Client> getAllStream() {
        return webClient.get()
                .uri("http://localhost:8282/client/stream")
                .exchangeToFlux(response -> response.bodyToFlux(Client.class))
                .doOnNext(cl -> {
                    log.info("Got Next Client {}", cl);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        log.error("Sleep interrupted", e);
                    }
                })
                .doOnSubscribe(s -> {
                    log.info("First Subscription");
                })
                .doOnCancel(() -> {
                    log.info("Stream was cancelled...");
                });
    }
}
