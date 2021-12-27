package br.com.meli.demo.usecases.GenerateCertificateUseCase;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.demo.model.Student;
import br.com.meli.demo.repository.StudentRepository;

@Service
public class GenerateCertificateService {

    @Autowired
    private StudentRepository studentRepository;

    public Map<String, Object> execute(String studentId) {
        Map<String, Object> info = new HashMap<>();

        Student student = studentRepository.getById(studentId);

        double sumGradeSubjects = student.getSubjects()
                .stream()
                .reduce(0.0, (acummulator, next) -> {
                    return acummulator + next.getGrade();
                }, Double::sum);

        double averageGrade = sumGradeSubjects / student.getSubjects().size();

        info.put("name", student.getName());
        info.put("averageGrade", averageGrade);

        if (averageGrade >= 9) {
            info.put("reward", "Parabéns, você obteve uma média acima de 9!");
        }

        return info;
    }
}
