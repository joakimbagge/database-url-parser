package dev.joakimbagge.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class DatabaseUrl {
    private String originalUrl;
    private String databaseType;
    private String host;
    private Integer port;
    private String databaseName;
}
