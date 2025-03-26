package dev.joakimbagge.parser;

import dev.joakimbagge.exception.InvalidJdbcUrlException;
import dev.joakimbagge.model.DatabaseUrl;
import dev.joakimbagge.model.JdbcUrl;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MysqlUrlParser implements JdbcUrlParser {

    private static final Pattern MYSQL_URL_PATTERN = Pattern.compile(
            "jdbc:mysql:\\/\\/(?<host>[\\w.-]+)(:(?<port>\\d+))?\\/(?<database>\\w+)(\\?(?<params>.*))?"
    );

    @Override
    public DatabaseUrl parse(String url) {
        Matcher matcher = MYSQL_URL_PATTERN.matcher(url);

        if (!matcher.find()) {
            throw new InvalidJdbcUrlException("Invalid JDBC URL format: " + url);
        }

        String host = matcher.group("host");
        Integer port = matcher.group("port") != null ? Integer.parseInt(matcher.group("port")) : 3306;
        String databaseName = matcher.group("database");
        String params = matcher.group("params");
        Map<String, String> parameters = UrlParameterParser.parseParameters(params);
        String username = parameters.getOrDefault("user", null);
        String password = parameters.getOrDefault("password", null);

        // Skapa och returnera en MysqlUrl
        return new JdbcUrl(url, "mysql", host, port, databaseName, username, password, parameters);
    }
}
