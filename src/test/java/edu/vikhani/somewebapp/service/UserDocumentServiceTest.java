package edu.vikhani.somewebapp.service;

import edu.vikhani.somewebapp.model.DocumentType;
import edu.vikhani.somewebapp.model.UserDocument;
import edu.vikhani.somewebapp.repository.UserDocumentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDocumentServiceTest {

    @Mock
    private UserDocumentRepository repository;

    @InjectMocks
    private UserDocumentService service;

    @Test
    void shouldReturnDocumentsForUser() {
        var doc = UserDocument.builder()
                .userName("john")
                .documentType(DocumentType.PASSPORT)
                .documentNumber("A123456")
                .build();

        when(repository.findByUserName("john")).thenReturn(List.of(doc));

        var result = service.getDocumentsForUser("john");

        assertEquals(1, result.size());
        assertEquals("john", result.get(0).getUserName());
    }
}
