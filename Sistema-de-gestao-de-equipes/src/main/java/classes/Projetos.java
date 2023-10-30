package classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Projetos {

    private String nome;
    private String descricao;
    private List<Tarefa> tarefas;
    private List<Membro> membros;
    private LocalDateTime prazo;

    public Projetos(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
        this.membros = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    public List<String> listarTodosMembrosDoProjeto() {
        return membros.stream()
                .map(Membro::getNome)
                .collect(Collectors.toList());
    }

    public List<String> listarTarefasAtrasadas() {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getPrazoFinal().isBefore(LocalDateTime.now())
                        && tarefa.getStatus() != StatusTarefa.CONCLUIDA)
                .map(Tarefa::getNome)
                .collect(Collectors.toList());
    }

    public void criarPrazo(String dia, String mes, String ano) {
        setPrazo(LocalDateTime.of(Integer.parseInt(ano),
                Integer.parseInt(mes),
                Integer.parseInt(dia),
                0, 0));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 50) {
            throw new RuntimeException("Nome do projeto não pode ter mais de 50 caracteres");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao.isEmpty()) {
            throw new RuntimeException("Descrição do projeto não pode ser vazia");
        }
        this.descricao = descricao;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public List<Tarefa> getTarefas() {
        return this.tarefas;
    }
}
