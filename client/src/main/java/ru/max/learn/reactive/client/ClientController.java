package ru.max.learn.reactive.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.max.learn.reactive.client.domain.Client;

@Slf4j
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping(path = "/stream/{limit}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Client> getAllUsingWebClient(@PathVariable("limit") int limit) {
        return service.getAllClients();
    }
}
