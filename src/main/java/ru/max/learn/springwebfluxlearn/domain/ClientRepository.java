package ru.max.learn.springwebfluxlearn.domain;

import java.util.stream.Stream;

public interface ClientRepository {

    Client getByName(String name);

    Stream<Client> getAllClients();
}
