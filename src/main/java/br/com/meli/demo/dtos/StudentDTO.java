package br.com.meli.demo.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private String name;
    private List<SubjectDTO> subjects;
}
