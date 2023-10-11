package domain;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String sigla;
    private String nome;
    private List<Matricula> matriculas;
    private List<Aula> aulas;


    public Curso(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
        this.matriculas = new ArrayList<>();
        this.aulas = new ArrayList<>();
    }
}
