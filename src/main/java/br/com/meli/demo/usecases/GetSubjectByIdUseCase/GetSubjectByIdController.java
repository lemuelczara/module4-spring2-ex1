package br.com.meli.demo.usecases.GetSubjectByIdUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.demo.model.Subject;

@RestController
@RequestMapping(path = "/api/v1")
public class GetSubjectByIdController {

    @Autowired
    private GetSubjectByIdService service;

    @GetMapping(path = "/subjects/{id}")
    public ResponseEntity<Subject> handle(@PathVariable String id) {
        Subject subject = service.execute(id);

        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
}
