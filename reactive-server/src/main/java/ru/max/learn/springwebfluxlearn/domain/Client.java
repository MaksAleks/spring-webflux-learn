package ru.max.learn.springwebfluxlearn.domain;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Value
@Builder
@Jacksonized
public class Client {
    UUID id;
    String name;
    Integer age;
}
