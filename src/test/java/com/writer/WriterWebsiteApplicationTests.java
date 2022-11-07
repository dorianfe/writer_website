package com.writer;

import com.writer.bll.PublicationService;
import com.writer.bll.UserService;
import com.writer.bo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class WriterWebsiteApplicationTests {

    @Autowired
    UserService beanUserService;

    @Autowired
    PublicationService beanPublicationService;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreationPublicationBdd() {
        Author ecrivain = new Author();
        Publication roman = new Novel("le Titre", "fiction", "Lorem ipsum blablabla", "synopsys lorem", LocalDate.now(), LocalDate.now(), ecrivain, Language.FRENCH, 6000, 25);
        beanUserService.addUser(ecrivain);
        beanPublicationService.addPublication(roman);
    }

    @Test
    void testGetPublicationsIfExist() {
        System.out.println(beanPublicationService.listAll());

    }

}
