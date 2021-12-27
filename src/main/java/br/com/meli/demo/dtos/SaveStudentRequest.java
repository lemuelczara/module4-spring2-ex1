package br.com.meli.demo.dtos;

import java.util.List;

import lombok.Getter;

@Getter
public class SaveStudentRequest {
    private String name;
    private List<Subjects> subjects;
    
    @Getter
    public static class Subjects {
        private String id;
    }
}