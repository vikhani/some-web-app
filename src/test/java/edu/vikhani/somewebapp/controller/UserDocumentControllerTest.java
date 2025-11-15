package edu.vikhani.somewebapp.controller;

import edu.vikhani.somewebapp.model.DocumentType;
import edu.vikhani.somewebapp.model.UserDocument;
import edu.vikhani.somewebapp.service.UserDocumentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(UserDocumentController.class)
class UserDocumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserDocumentService service;

    @Test
    void shouldReturnDocumentsForUser() throws Exception {
        var doc = UserDocument.builder()
                .userName("alice")
                .documentType(DocumentType.ID_CARD)
                .documentNumber("ID-001")
                .build();

        when(service.getDocumentsForUser("alice")).thenReturn(List.of(doc));

        mockMvc.perform(get("/api/documents/alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userName").value("alice"));
    }
}
