package com.scjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class IspServiceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(IspServiceAppApplication.class, args);
    }

}
