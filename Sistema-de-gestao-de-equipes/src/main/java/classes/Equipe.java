package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Equipe {

    private String nome;
    private List<Projeto> projetos;

    public Equipe(String nome) {
        setNome(nome);
        this.projetos = new ArrayList<>();
    }

    public List<String> listarTodosProjetos() {
        if (projetos.isEmpty()) {
            throw new RuntimeException("Não há projetos alocados a essa equipe");
        }
        return projetos.stream()
                .map(Projeto::getNome)
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

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
