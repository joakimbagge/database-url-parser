package parser;

import dev.joakimbagge.factory.JdbcUrlParserFactory;
import dev.joakimbagge.model.DatabaseUrl;
import dev.joakimbagge.model.JdbcUrl;
import dev.joakimbagge.parser.JdbcUrlParser;
import dev.joakimbagge.parser.MysqlUrlParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class JdbcUrlParserFactoryTest {

    @Test
    void givenMysqlJdbcUrl_thenJdbcUrlCreated() {
        // Arrange
        String mysqlUrl = "jdbc:mysql://localhost:3306/testdb?user=root&password=secret&useSSL=false";

        // Act
        JdbcUrlParser parser = JdbcUrlParserFactory.getParser(mysqlUrl);
        DatabaseUrl parsedUrl = parser.parse(mysqlUrl);

        // Assert
        assertThat(parser).isInstanceOf(MysqlUrlParser.class);
        assertThat(parsedUrl).isInstanceOf(JdbcUrl.class);
        JdbcUrl jdbcUrl = (JdbcUrl) parsedUrl;
        assertThat(jdbcUrl.getOriginalUrl()).isEqualTo(mysqlUrl);
        assertThat(jdbcUrl.getHost()).isEqualTo("localhost");
        assertThat(jdbcUrl.getPort()).isEqualTo(3306);
        assertThat(jdbcUrl.getDatabaseName()).isEqualTo("testdb");
        assertThat(jdbcUrl.getUsername()).isEqualTo("root");
        assertThat(jdbcUrl.getPassword()).isEqualTo("secret");

        // Kontrollera parametrar
        assertThat(jdbcUrl.getParameters()).containsEntry("user", "root")
                .containsEntry("password", "secret")
                .containsEntry("useSSL", "false");
    }
}
