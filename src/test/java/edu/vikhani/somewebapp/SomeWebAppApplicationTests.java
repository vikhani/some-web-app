package edu.vikhani.somewebapp;

import edu.vikhani.somewebapp.controller.UserDocumentController;
import edu.vikhani.somewebapp.service.UserDocumentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SomeWebAppApplicationTests {

    @Autowired
    private UserDocumentController userDocumentController;

    @Autowired
    private UserDocumentService userDocumentService;

    @Test
    void contextLoads() {
        assertThat(userDocumentController).isNotNull();
        assertThat(userDocumentService).isNotNull();
    }

}
