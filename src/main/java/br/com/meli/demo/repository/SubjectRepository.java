package br.com.meli.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.demo.model.Subject;

@Repository(value = "SubjectRepository")
public class SubjectRepository {
    private List<Subject> subjects = new ArrayList<>();

    public Subject save(Subject subject) {
        subjects.add(subject);

        return subject;
    }

    public Subject getById(String id) {
        return subjects
                .stream()
                .filter(subject -> subject.getId().toString().equalsIgnoreCase(id))
                .findFirst()
                .get();
    }
}
