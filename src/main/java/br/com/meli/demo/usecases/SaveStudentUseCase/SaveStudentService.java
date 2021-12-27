package br.com.meli.demo.usecases.SaveStudentUseCase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.demo.dtos.SaveStudentRequest;
import br.com.meli.demo.model.Student;
import br.com.meli.demo.model.Subject;
import br.com.meli.demo.repository.StudentRepository;
import br.com.meli.demo.repository.SubjectRepository;
import br.com.meli.demo.utils.GenerateRandomUUID;

@Service
public class SaveStudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student execute(SaveStudentRequest saveStudentRequest) {
        List<Subject> subjects = new ArrayList<>();

        Student student = new Student();
        student.setId(GenerateRandomUUID.generate());
        student.setName(saveStudentRequest.getName());

        saveStudentRequest.getSubjects()
                .stream()
                .forEach(studentRequest -> {
                    Subject subject = new Subject();

                    subject = subjectRepository.getById(studentRequest.getId());

                    subjects.add(subject);
                });

        student.setSubjects(subjects);
        student.setCreatedAt(LocalDate.now());

        return repository.save(student);
    }
}
