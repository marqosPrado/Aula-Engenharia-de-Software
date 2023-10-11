package domain;

import java.time.LocalDateTime;
import java.util.List;

public class Matricula {

    private Aluno aluno;
    private List<Nota> notas;
    private LocalDateTime data;

    public Matricula(Aluno aluno, List<Nota> notas) {
        data = LocalDateTime.now();
        this.aluno = aluno;
        this.notas = notas;
    }

    public float obterMedia() {
        return getNotas().get(0).mediaAritmetica();
    }


    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
