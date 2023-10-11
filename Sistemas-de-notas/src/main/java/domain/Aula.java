package domain;

import java.util.List;

public class Aula {

    private String titulo;

    private List<Matricula> matriculas;

    public Aula(String titulo, List<Matricula> matriculas) {
        this.titulo = titulo;
        this.matriculas = matriculas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
