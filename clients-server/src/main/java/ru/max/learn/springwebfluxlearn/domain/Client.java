package ru.max.learn.springwebfluxlearn.domain;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Value
@Builder
@Jacksonized
@Table("clients")
public class Client {
    @Id
    UUID id;
    String name;
    Integer age;
}
