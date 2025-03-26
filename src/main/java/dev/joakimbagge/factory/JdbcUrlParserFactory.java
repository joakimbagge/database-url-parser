package dev.joakimbagge.factory;

import dev.joakimbagge.exception.InvalidJdbcUrlException;
import dev.joakimbagge.parser.JdbcUrlParser;
import dev.joakimbagge.parser.MongoDbUrlParser;
import dev.joakimbagge.parser.MysqlUrlParser;

public class JdbcUrlParserFactory {

    private JdbcUrlParserFactory() {
    }

    public static JdbcUrlParser getParser(String url) {
        if (url.startsWith("jdbc:mysql://")) {
            return new MysqlUrlParser();
        } else if (url.startsWith("mongodb://")) {
            return new MongoDbUrlParser();
        } else {
            throw new InvalidJdbcUrlException("Unsupported database type in URL: " + url);
        }
    }
}
