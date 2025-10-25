package com.org.moviemania.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DatabaseHealthCheck {

    private final DatabaseClient databaseClient;

    public DatabaseHealthCheck(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void verifyConnection() {
        Mono<Boolean> check = databaseClient.sql("SELECT 1")
                .map(row -> row.get(0, Integer.class))
                .first()
                .map(result -> true)
                .onErrorResume(e -> {
                    System.err.println("❌ Database connection failed: " + e.getMessage());
                    return Mono.just(false);
                });

        check.subscribe(success -> {
            if (success) {
                System.out.println("✅ Database connection successful!");
            }
        });
    }
}

