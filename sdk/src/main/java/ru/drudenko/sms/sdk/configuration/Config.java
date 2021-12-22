package ru.drudenko.sms.sdk.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.drudenko.sms.sdk.SmsServiceFacade;

@Configuration
public class Config {

    @Value("${sms.sdk.url}")
    private String url;

    @Bean
    public SmsServiceFacade smsServiceFacade() {
        return new SmsServiceFacade(restTemplate());
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .rootUri(url)
                .build();
    }
}
