package edu.vikhani.somewebapp.controller;

import edu.vikhani.somewebapp.model.UserDocument;
import edu.vikhani.somewebapp.service.UserDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class UserDocumentController {

    private final UserDocumentService service;

    @GetMapping("/{userName}")
    public ResponseEntity<List<UserDocument>> getDocuments(@PathVariable String userName) {
        return ResponseEntity.ok(service.getDocumentsForUser(userName));
    }

    @PostMapping
    public ResponseEntity<UserDocument> createDocument(@RequestBody UserDocument document) {
        return ResponseEntity.ok(service.saveDocument(document));
    }
}

