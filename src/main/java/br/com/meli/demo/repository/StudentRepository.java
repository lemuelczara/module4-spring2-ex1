package br.com.meli.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.demo.model.Student;

@Repository(value = "StudentRepository")
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public Student save(Student student) {
        students.add(student);

        return student;
    }

    public Student getById(String id) {
        return students
                .stream()
                .filter(student -> student.getId().toString().equalsIgnoreCase(id))
                .findFirst()
                .get();
    }
}
