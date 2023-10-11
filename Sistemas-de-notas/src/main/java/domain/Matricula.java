package domain;

import java.time.LocalDateTime;
import java.util.List;

public class Matricula {

    private LocalDateTime data;
    private Aluno aluno;
    private List<Nota> notas;

    public Matricula(Aluno aluno, List<Nota> notas) {
        data = LocalDateTime.now();
        this.aluno = aluno;
        this.notas = notas;
    }

}
