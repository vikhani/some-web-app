package edu.vikhani.somewebapp.service;

import edu.vikhani.somewebapp.model.UserDocument;
import edu.vikhani.somewebapp.repository.UserDocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDocumentService {

    private final UserDocumentRepository repository;

    public List<UserDocument> getDocumentsForUser(String userName) {
        return repository.findByUserName(userName);
    }

    public UserDocument saveDocument(UserDocument doc) {
        return repository.save(doc);
    }

    public void x() {
        log.info("This method breaks Checkstyle rule!");
    }
}
