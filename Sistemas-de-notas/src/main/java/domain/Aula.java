package domain;


public class Aula {

    private String tituloDaAula;
    private Nota notaAluno;
    private int quantidadeAulas;

    public Aula(String tituloDaAula, int quantidadeAulas) {
        this.tituloDaAula = tituloDaAula;
        this.quantidadeAulas = quantidadeAulas;
    }

    public String getTituloDaAula() {
        return tituloDaAula;
    }

    public void setTituloDaAula(String tituloDaAula) {
        this.tituloDaAula = tituloDaAula;
    }

    public Nota getNotaAluno() {
        return notaAluno;
    }

    public void setNotaAluno(Nota notaAluno) {
        this.notaAluno = notaAluno;
    }

    public int getQuantidadeAulas() {
        return quantidadeAulas;
    }

    public void setQuantidadeAulas(int quantidadeAulas) {
        this.quantidadeAulas = quantidadeAulas;
    }
}
