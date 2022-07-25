package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import java.time.Instant;

@MicronautTest
class BrokenQueryTest {

    @Inject
    BrokenRepository repository;

    @Test
    void testItWorks() {
        BrokenEntity entity = new BrokenEntity(null, "Value", Instant.now());
        repository.update(entity);
    }
}
