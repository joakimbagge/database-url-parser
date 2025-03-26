package dev.joakimbagge;

import dev.joakimbagge.factory.DatabaseConnectionFactory;
import dev.joakimbagge.factory.JdbcUrlParserFactory;
import dev.joakimbagge.model.DatabaseUrl;
import dev.joakimbagge.parser.JdbcUrlParser;
import dev.joakimbagge.strategy.DatabaseConnectionStrategy;

public class DatabaseConnector {
    public static Object connectToDatabase(String jdbcUrlString) throws Exception {
        // Läs in JDBC URL
        JdbcUrlParser parser = JdbcUrlParserFactory.getParser(jdbcUrlString);
        DatabaseUrl jdbcUrl = parser.parse(jdbcUrlString);

        // Anslut till databasen
        DatabaseConnectionStrategy connectionStrategy = DatabaseConnectionFactory.getDatabaseConnectionStrategy(jdbcUrl);
        return connectionStrategy.connect(jdbcUrl);
    }
}
