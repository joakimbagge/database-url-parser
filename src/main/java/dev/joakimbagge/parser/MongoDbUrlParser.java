package dev.joakimbagge.parser;

import dev.joakimbagge.exception.InvalidJdbcUrlException;
import dev.joakimbagge.model.DatabaseUrl;
import dev.joakimbagge.model.MongoUrl;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MongoDbUrlParser implements JdbcUrlParser {

    private static final Pattern MONGODB_URL_PATTERN = Pattern.compile(
            "mongodb:\\/\\/(?<host>[\\w.-]+)(:(?<port>\\d+))?\\/(?<database>\\w+)(\\?(?<params>.*))?"
    );

    @Override
    public DatabaseUrl parse(String url) {

        Matcher matcher = MONGODB_URL_PATTERN.matcher(url);
        if (!matcher.find()) {
            throw new InvalidJdbcUrlException("Invalid MongoDB URL format: " + url);
        }

        String host = matcher.group("host");
        Integer port = matcher.group("port") != null ? Integer.parseInt(matcher.group("port")) : 27017;  // Standardport för MongoDB
        String databaseName = matcher.group("database");

        String params = matcher.group("params");
        Map<String, String> parameters = UrlParameterParser.parseParameters(params);

        return new MongoUrl(url, "mongodb", host, port, databaseName, parameters);
    }
}
