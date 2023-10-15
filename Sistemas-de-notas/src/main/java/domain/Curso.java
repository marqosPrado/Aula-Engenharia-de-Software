package domain;

import java.util.List;


public class Curso {

    private String sigla;
    private String nome;
    private List<Matricula> matriculas;
    private Aula aula;


    public Curso(String sigla, String nome, List<Matricula> matriculas, Aula aula) {
        this.sigla = sigla;
        this.nome = nome;
        this.matriculas = matriculas;
        this.aula = aula;
    }

    public double calcularMediaGeral() {
        double soma = 0;
        for (Matricula matricula : matriculas) {
            soma += matricula.getNota().calcularMedia();
        }
        return soma / matriculas.size();
    }

    public void mostrarAlunosReprovados() {
        int totalAulas = getAula().getQuantidadeAulas();
        int limiteFaltas = (int) (totalAulas * 0.25);

        for (Matricula matricula : matriculas) {
            int countFaltas = 0;
            List<Presenca> presenca = matricula.getPresenca();
            if (presenca == null) continue;
            for (Presenca falta : presenca) {
                if (falta.equals(Presenca.FALTA)) {
                    countFaltas += 1;
                }
            }
            if (countFaltas > limiteFaltas) {
                System.out.println("Aluno: " + matricula.getAluno().getNome() + " está reprovado por falta");
            }
        }
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

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
}
