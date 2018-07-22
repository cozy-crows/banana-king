package com.example.bananaking.config.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Created by jerry on 2018/5/4.
 *
 * @author jerry
 */
@Configuration
public class JacksonConfiguration {

    /**
     * 採用 {@link JavaTimeModule} 來做為日期與時間相關的序列化標準
     * Example: http://www.baeldung.com/jackson-serialize-dates
     * <p>
     * 相關文件
     * https://github.com/FasterXML/jackson-databind/wiki
     * http://www.joda.org/joda-time/
     *
     * @return {@link Jackson2ObjectMapperBuilder}
     */
    @Bean
    Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {

        return new Jackson2ObjectMapperBuilder()
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .findModulesViaServiceLoader(true)
            .modulesToInstall(new JavaTimeModule());
    }
}
