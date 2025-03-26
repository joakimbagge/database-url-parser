package dev.joakimbagge.strategy;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dev.joakimbagge.model.DatabaseUrl;

public class MongoDatabaseConnection implements DatabaseConnectionStrategy {
    @Override
    public MongoClient connect(DatabaseUrl databaseUrl) {
        String url = "mongodb://" + databaseUrl.getHost() + ":" + databaseUrl.getPort() + "/" + databaseUrl.getDatabaseName();
        return MongoClients.create(url);
    }
}
