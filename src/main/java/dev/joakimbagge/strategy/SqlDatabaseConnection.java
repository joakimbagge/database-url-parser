package dev.joakimbagge.strategy;

import dev.joakimbagge.model.DatabaseUrl;
import dev.joakimbagge.model.JdbcUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Properties;

public class SqlDatabaseConnection implements DatabaseConnectionStrategy {
    @Override
    public Connection connect(DatabaseUrl databaseUrl) throws Exception {
        String url = "jdbc:" + databaseUrl.getDatabaseType() + "://" + databaseUrl.getHost() + ":" +
                databaseUrl.getPort() + "/" + databaseUrl.getDatabaseName();

        JdbcUrl jdbcUrl = (JdbcUrl) databaseUrl;
        Properties props = new Properties();
        props.setProperty("user", jdbcUrl.getUsername());
        props.setProperty("password", jdbcUrl.getPassword());

        for (Map.Entry<String, String> entry : jdbcUrl.getParameters().entrySet()) {
            props.setProperty(entry.getKey(), entry.getValue());
        }

        return DriverManager.getConnection(url, props);
    }
    
}
