package ru.max.learn.reactive.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.max.learn.reactive.client.domain.Client;

@Slf4j
@Service
public class ClientService {

    private final WebClient client;

    @Getter
    private final Flux<Client> allClients;

    public ClientService(WebClient webClient) {
        this.client = webClient;
        this.allClients = client.get().uri("http://localhost:8181/client/stream")
                .exchangeToFlux(response -> response.bodyToFlux(Client.class))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(client -> {
                    log.info("STREAM: Got next client");
                });
    }
}
