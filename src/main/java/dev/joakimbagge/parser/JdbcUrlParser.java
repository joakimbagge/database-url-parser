package dev.joakimbagge.parser;

import dev.joakimbagge.model.DatabaseUrl;

public interface JdbcUrlParser {

    DatabaseUrl parse(String url);
}
