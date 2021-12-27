package br.com.meli.demo.usecases.SaveStudentUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.demo.dtos.SaveStudentRequest;
import br.com.meli.demo.model.Student;

@RestController
@RequestMapping(path = "/api/v1")
public class SaveStudentController {

    @Autowired
    private SaveStudentService service;

    @PostMapping(path = "/students")
    public ResponseEntity<Student> handle(@RequestBody SaveStudentRequest httpRequestBody) {
        Student student = service.execute(httpRequestBody);
    
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
