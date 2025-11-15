package edu.vikhani.somewebapp.repository;

import edu.vikhani.somewebapp.model.DocumentType;
import edu.vikhani.somewebapp.model.UserDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserDocumentRepositoryTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16")
            .withDatabaseName("demo")
            .withUsername("demo")
            .withPassword("demo");

    @Autowired
    private UserDocumentRepository repository;

    @Test
    void shouldSaveAndFindByUserName() {
        var doc = UserDocument.builder()
                .userName("maria")
                .documentType(DocumentType.DRIVER_LICENSE)
                .documentNumber("DL-2023")
                .build();

        repository.save(doc);

        var result = repository.findByUserName("maria");

        assertEquals(1, result.size());
        assertEquals("DL-2023", result.get(0).getDocumentNumber());
    }
}
