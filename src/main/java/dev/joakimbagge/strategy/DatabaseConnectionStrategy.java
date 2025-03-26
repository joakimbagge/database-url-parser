package dev.joakimbagge.strategy;

import dev.joakimbagge.model.DatabaseUrl;

public interface DatabaseConnectionStrategy<T> {
    T connect(DatabaseUrl databaseUrl) throws Exception;
}
