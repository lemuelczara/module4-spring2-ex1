package br.com.meli.demo.usecases.SaveSubjectUseCase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.demo.dtos.SubjectDTO;
import br.com.meli.demo.model.Subject;

@RestController
@RequestMapping(path = "/api/v1")
public class SaveSubjectController {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private SaveSubjectService service;

    @PostMapping(path = "/subjects")
    public ResponseEntity<Subject> handle(@RequestBody SubjectDTO subjectDTO) {
        Subject subject = service.execute(convertToEntity(subjectDTO));

        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }

    private Subject convertToEntity(SubjectDTO subjectDTO) {
        return modelMapper.map(subjectDTO, Subject.class);
    }
}
