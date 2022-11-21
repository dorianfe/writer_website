package com.writer;

import com.writer.bo.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.time.LocalDate;

@SpringBootApplication
public class WriterWebsiteApplication {

   

    public static void main(String[] args) {
        SpringApplication.run(WriterWebsiteApplication.class, args);

    
    }


}
