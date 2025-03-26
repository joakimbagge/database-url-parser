package dev.joakimbagge.factory;

import dev.joakimbagge.model.DatabaseUrl;
import dev.joakimbagge.strategy.DatabaseConnectionStrategy;
import dev.joakimbagge.strategy.MongoDatabaseConnection;
import dev.joakimbagge.strategy.SqlDatabaseConnection;

public class DatabaseConnectionFactory {

    public static DatabaseConnectionStrategy getDatabaseConnectionStrategy(DatabaseUrl databaseUrl) {
        switch (databaseUrl.getDatabaseType()) {
            case "mysql":
            case "oracle": return new SqlDatabaseConnection();
            case "mongodb": return new MongoDatabaseConnection();
            default: throw new IllegalArgumentException("Unsupported database type: " + databaseUrl.getDatabaseType());
        }
    }
}
