package ru.gumerbaev.reactive.server.db;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
public class R2DBCConfiguration extends AbstractR2dbcConfiguration {

    @Value("${spring.r2dbc.url}")
    private String url;
    @Value("${spring.r2dbc.username}")
    private String username;
    @Value("${spring.r2dbc.password}")
    private String password;

    @Bean
    @Override
    public PostgresqlConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host(url.substring(url.indexOf("//") + 2, url.lastIndexOf(":")))
                        .port(Integer.parseInt(url.substring(url.lastIndexOf(":") + 1, url.lastIndexOf("/"))))
                        .database(url.substring(url.lastIndexOf("/") + 1))
                        .username(username).password(password)
                        .build());
    }
}