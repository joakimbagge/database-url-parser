package dev.joakimbagge.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
public class JdbcUrl extends DatabaseUrl {
    private String username;
    private String password;
    private Map<String, String> parameters;

    public JdbcUrl(String originalUrl, String databaseType, String host, int port, String databaseName, String username, String password, Map<String, String> parameters) {
        super(originalUrl, databaseType, host, port, databaseName);
        this.username = username;
        this.password = password;
        this.parameters = parameters;
    }
}
