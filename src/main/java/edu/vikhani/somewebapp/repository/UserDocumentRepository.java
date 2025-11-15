package edu.vikhani.somewebapp.repository;

import edu.vikhani.somewebapp.model.UserDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDocumentRepository extends JpaRepository<UserDocument, Long> {
    List<UserDocument> findByUserName(String userName);
}
