package de.sevensender.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
class ComicStripsConfig {
    /**
     * Format the font of result (jsons) to Upper Camel Case.
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizeJson() {
        return builder -> {

            builder.indentOutput(true);
            builder.propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        };
    }
}


