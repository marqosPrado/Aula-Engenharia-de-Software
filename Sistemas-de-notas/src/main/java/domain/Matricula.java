package domain;

import java.time.LocalDateTime;
import java.util.List;

public class Matricula {
    private Aluno aluno;
    private LocalDateTime dataDeMatricula;
    private Nota nota;
    private List<Presenca> presenca;

    public Matricula(Aluno aluno, LocalDateTime dataDeMatricula) {
        setAluno(aluno);
        setDataDeMatricula(dataDeMatricula);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDateTime getDataDeMatricula() {
        return dataDeMatricula;
    }

    public void setDataDeMatricula(LocalDateTime dataDeMatricula) {
        this.dataDeMatricula = dataDeMatricula;
    }

    public List<Presenca> getPresenca() {
        return presenca;
    }

    public void setPresenca(List<Presenca> presenca) {
        this.presenca = presenca;
    }
}
