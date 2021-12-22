package ru.drudenko.sms.testclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.drudenko.sms.sdk.configuration.Config;

/**
 * created 22/12/2021
 *
 * @author Rudenko Dmitry
 */
@Import(Config.class)
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
