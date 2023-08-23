package ru.max.learn.springwebfluxlearn.infra;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import ru.max.learn.springwebfluxlearn.domain.Client;
import ru.max.learn.springwebfluxlearn.domain.ClientRepository;

import java.util.UUID;
import java.util.stream.Stream;

public interface ClientJpaRepository extends CrudRepository<Client, UUID>, ClientRepository {

    @Override
    @Query("select * from clients")
    Stream<Client> getAllClients();
}
