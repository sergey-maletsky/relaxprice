package ru.relaxprice.maletsky.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource({
        "classpath:spring/application.properties",
        "classpath:spring/database.properties"
})
/*@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        jsr250Enabled = true,
        securedEnabled = true
)*/
public class RelaxPriceConfiguration {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    public Flyway flyway(DataSource dataSource) {

        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setOutOfOrder(true);
        flyway.repair();
        flyway.migrate();

        return flyway;
    }

    @Bean
    public MultipartProperties multipartProperties() {
        MultipartProperties properties = new MultipartProperties();
        properties.setMaxFileSize("25MB");
        properties.setMaxRequestSize("25MB");
        return properties;
    }
}
