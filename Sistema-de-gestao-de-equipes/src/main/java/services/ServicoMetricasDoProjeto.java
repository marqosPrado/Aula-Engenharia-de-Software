package services;

import classes.Projetos;
import classes.StatusTarefa;
import classes.Tarefa;

import java.util.List;

public class ServicoMetricasDoProjeto {
    public static double calcularPorcentagemTarefasConcluidas(Projetos projeto) {
        List<Tarefa> tarefas = projeto.getTarefas();
        if (tarefas.isEmpty()) throw new RuntimeException("Não há tarefas no projeto");
        return (double) tarefas.stream()
                .filter(tarefa -> tarefa.getStatus() == StatusTarefa.CONCLUIDA)
                .count()
                / tarefas.size()
                * 100;
    }
}
