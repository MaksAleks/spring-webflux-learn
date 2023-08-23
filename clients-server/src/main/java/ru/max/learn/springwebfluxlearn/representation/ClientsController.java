package ru.max.learn.springwebfluxlearn.representation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.max.learn.springwebfluxlearn.domain.Client;
import ru.max.learn.springwebfluxlearn.domain.ClientRepository;

import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientsController {

    private final ClientRepository repository;

    @GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Client> getAllStream() {
        return Flux.fromStream(repository.getAllClients());
    }
}
