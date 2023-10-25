package classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tarefa {

    private String nome;
    private String descricao;
    private Membro lider;
    private List<Membro> membros;
    private StatusTarefa status;
    private LocalDateTime prazoInicio;
    private LocalDateTime prazoFinal;
    private LocalDateTime dataConclusao;


    public Tarefa(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
        this.status = StatusTarefa.PENDENTE;
        this.membros = new ArrayList<>();
    }

    public void alocarLider(Membro lider) {
        if (lider == null) {
            throw new RuntimeException("Lider não pode ser nulo");
        }
        setLider(lider);
    }

    public void alocarMembro(Membro membro) {
        if (membro == null) {
            throw new RuntimeException("Membro não pode ser nulo");
        }
        membros.add(membro);
    }


    public void alocarTodosMembros(List<Membro> membros) {
        setMembros(membros);
    }

    public List<String> listarTodosMembros() {
        if (membros.isEmpty()) {
            throw new RuntimeException("Tarefa não tem membros");
        }

        return membros.stream()
                .map(Membro::getNome)
                .collect(java.util.stream.Collectors.toList());
    }

    public void removerMembro(String id) {
        if (membros.isEmpty()) {
            throw new RuntimeException("Tarefa não tem membros");
        }
        if (!existeMembro(id)) {
            throw new RuntimeException("Membro não existe");
        }
        membros.removeIf(membro -> membro.getId().equals(id));
    }

    public void removerTodosMembros(List<Membro> membros) {
        if (membros.isEmpty()) {
            throw new RuntimeException("Tarefa não tem membros");
        }
        membros.clear();
    }

    public void removerLider() {
        setLider(null);
    }

    public void criarPrazoInicio(String dia, String mes, String ano) {
        LocalDateTime prazo = (LocalDateTime.of(Integer.parseInt(ano),
                Integer.parseInt(mes),
                Integer.parseInt(dia),
                0, 0));

        setPrazoInicio(prazo);
    }

    public void criarPrazoFinal(String dia, String mes, String ano) {
        LocalDateTime prazo = (LocalDateTime.of(Integer.parseInt(ano),
                Integer.parseInt(mes),
                Integer.parseInt(dia),
                0, 0));

        if (getPrazoInicio() == null) {
            throw new RuntimeException("Prazo inicial não pode ser depois do prazo final");
        }

        if (prazo.isBefore(getPrazoInicio())) {
            throw new RuntimeException("Prazo final não pode ser antes do prazo inicial");
        }
        setPrazoFinal(prazo);
    }

    public void iniciarTarefa() {
        if (getStatus() == StatusTarefa.PENDENTE) {
            setStatus(StatusTarefa.EM_ANDAMENTO);
        } else {
            throw new RuntimeException("Tarefa não pode ser iniciada");
        }
    }

    public void concluirTarefa() {
        if (getStatus() == StatusTarefa.EM_ANDAMENTO) {
            setStatus(StatusTarefa.CONCLUIDA);
            setDataConclusao(LocalDateTime.now());
        } else {
            throw new RuntimeException("Tarefa não pode ser concluída");
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public LocalDateTime getPrazoInicio() {
        return prazoInicio;
    }

    public void setPrazoInicio(LocalDateTime prazoInicio) {
        this.prazoInicio = prazoInicio;
    }

    public LocalDateTime getPrazoFinal() {
        return prazoFinal;
    }

    public void setPrazoFinal(LocalDateTime prazoFinal) {
        this.prazoFinal = prazoFinal;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public Membro getLider() {
        return lider;
    }

    public void setLider(Membro lider) {
        this.lider = lider;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    private boolean existeMembro(String id) {
        return membros.stream()
                .anyMatch(membro -> membro.getId().equals(id));
    }

}
