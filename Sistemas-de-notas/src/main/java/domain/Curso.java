package domain;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String sigla;
    private String nome;
    private List<Matricula> matriculas;
    private List<Aula> aulas;

    public Curso(String sigla, String nome, List<Matricula> matriculas,
                 List<Aula> aulas) {
        this.sigla = sigla;
        this.nome = nome;
        this.matriculas = matriculas;
        this.aulas = aulas;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
}
