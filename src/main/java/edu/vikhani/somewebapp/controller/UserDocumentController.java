package edu.vikhani.somewebapp.controller;

import edu.vikhani.somewebapp.model.UserDocument;
import edu.vikhani.somewebapp.service.UserDocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class UserDocumentController {

    private final UserDocumentService service;

    @GetMapping("/{userName}")
    public ResponseEntity<List<UserDocument>> getDocuments(@PathVariable String userName) {
        log.debug("1");
        log.debug("2");
        log.debug("3");
        log.debug("4");
        log.debug("5");
        log.debug("6");
        return ResponseEntity.ok(service.getDocumentsForUser(userName));
    }

    @PostMapping
    public ResponseEntity<UserDocument> createDocument(@RequestBody UserDocument document) {
        return ResponseEntity.ok(service.saveDocument(document));
    }
}

