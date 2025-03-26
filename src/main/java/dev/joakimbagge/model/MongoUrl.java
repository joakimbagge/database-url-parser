package dev.joakimbagge.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class MongoUrl extends DatabaseUrl {
    private Map<String, String> parameters;
    public MongoUrl(String originalUrl, String databaseType, String host, int port, String databaseName, Map<String, String> parameters) {
        super(originalUrl, "mongodb", host, port, databaseName);
        this.parameters = parameters;
    }
}
