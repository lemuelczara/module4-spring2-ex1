package br.com.meli.demo.usecases.GetSubjectByIdUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.demo.model.Subject;
import br.com.meli.demo.repository.SubjectRepository;

@Service
public class GetSubjectByIdService {
    
    @Autowired
    private SubjectRepository repository;

    public Subject execute(String id) {
        return repository.getById(id);
    }
}
