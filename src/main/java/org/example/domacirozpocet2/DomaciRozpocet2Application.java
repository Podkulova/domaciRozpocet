package org.example.domacirozpocet2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DomaciRozpocet2Application {

    public static void main(String[] args) {
        SpringApplication.run(DomaciRozpocet2Application.class, args);
        log.info("Aplikace běží na adrese: http://localhost:8080/");
    }

}
