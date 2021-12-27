package br.com.meli.demo.usecases.GenerateCertificateUseCase;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class GenerateCertificateController {

    @Autowired
    private GenerateCertificateService service;

    @GetMapping(path = "/students/{studentId}/average")
    public ResponseEntity<Map<String, Object>> handle(@PathVariable String studentId) {
        Map<String, Object> response = service.execute(studentId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
