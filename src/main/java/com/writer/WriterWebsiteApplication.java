package com.writer;

import com.writer.bll.PublicationService;
import com.writer.bll.UserService;
import com.writer.bo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;

@SpringBootApplication
public class WriterWebsiteApplication {

   

    public static void main(String[] args) {
        SpringApplication.run(WriterWebsiteApplication.class, args);

    
    }




}
