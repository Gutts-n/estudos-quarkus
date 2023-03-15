package com.github.farias.yuri.leonardo.ifood;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegistrationLifecycleManager implements QuarkusTestResourceLifecycleManager {

    public static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:14.4");

    @Override
    public Map<String, String> start() {
        POSTGRES.start();
        var properties = new HashMap<String, String>();
        properties.put("quarkus.datasource.url", POSTGRES.getJdbcUrl());
        properties.put("quarkus.datasource.username", POSTGRES.getUsername());
        properties.put("quarkus.datasource.password", POSTGRES.getPassword());
        properties.put("docker.host", "unix:///var/run/docker.sock");

        return properties;
    }

    @Override
    public void stop() {
        if (Objects.nonNull(POSTGRES) && POSTGRES.isRunning()) {
            POSTGRES.stop();
        }
    }
}
