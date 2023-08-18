package ru.max.learn.springwebfluxlearn.representation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.max.learn.springwebfluxlearn.domain.Client;
import ru.max.learn.springwebfluxlearn.domain.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientsController {

    private final ClientRepository repository;

    @GetMapping
    public Flux<Client> getAll() {
        return Flux.fromStream(repository.getAllClients());
    }

    @GetMapping("/list")
    public List<Client> getAllList() {
        return repository.getAllClients().collect(Collectors.toList());
    }
}
