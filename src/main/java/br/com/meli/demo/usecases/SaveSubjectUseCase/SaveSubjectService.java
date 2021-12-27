package br.com.meli.demo.usecases.SaveSubjectUseCase;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.demo.model.Subject;
import br.com.meli.demo.repository.SubjectRepository;
import br.com.meli.demo.utils.GenerateRandomUUID;

@Service
public class SaveSubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject execute(Subject subject) {
        subject.setId(GenerateRandomUUID.generate().toString());
        subject.setCreatedAt(LocalDate.now());
        
        return subjectRepository.save(subject);
    }
}
