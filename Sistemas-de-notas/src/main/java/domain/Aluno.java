package domain;

public class Aluno {

    private String ra;
    private String nome;

    public Aluno(String ra, String nome) {
        setRa(ra);
        setNome(nome);
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
