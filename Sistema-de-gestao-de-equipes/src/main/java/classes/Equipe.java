package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Equipe {

    private String nome;
    private List<Projetos> projetos;

    public Equipe(String nome) {
        setNome(nome);
        this.projetos = new ArrayList<>();
    }

    public List<String> listarTodosMembrosDoProjeto() {
        return projetos.stream()
                .flatMap(projeto -> projeto.listarTodosMembrosDoProjeto().stream())
                .collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 50) {
            throw new RuntimeException("Nome da equipe não pode ter mais de 50 caracteres");
        }
        this.nome = nome;
    }

    public void setProjetos(List<Projetos> projetos) {
        this.projetos = projetos;
    }
}
