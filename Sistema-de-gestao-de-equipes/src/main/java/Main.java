import classes.Equipe;
import classes.Membro;
import classes.Projetos;
import classes.Tarefa;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Membros =================================================================================
        Membro marcos = new Membro("1", "Marcos Prado");
        Membro joao = new Membro("2", "João");
        Membro maria = new Membro("3", "Maria");
        Membro pedro = new Membro("4", "Pedro");

        List<Membro> membros = new ArrayList<>();
        membros.add(marcos);
        membros.add(joao);
        membros.add(maria);
        membros.add(pedro);

        // ================================= Projeto ===============================================
        Projetos projeto = new Projetos("Projeto sebrae", "Projeto para o sebrae");
        projeto.criarPrazo("31", "10", "2023");
        projeto.setMembros(membros);

        List<Projetos> listaProjetos = new ArrayList<>();
        listaProjetos.add(projeto);

        // Tarefa ==================================================================================
        Tarefa tarefa1 = new Tarefa("Criar o projeto", "Criação do projeto");
        tarefa1.criarPrazoInicio("24", "10", "2023");
        tarefa1.criarPrazoFinal("25", "10", "2023");
        tarefa1.alocarMembro(joao);
        tarefa1.alocarLider(marcos);

        Tarefa tarefa2 = new Tarefa("Tela inicial", "Criar a tela inicial");
        tarefa2.criarPrazoInicio("26", "10", "2023");
        tarefa2.criarPrazoFinal("27", "10", "2023");
        tarefa2.alocarMembro(maria);
        tarefa2.alocarMembro(joao);
        tarefa2.alocarLider(marcos);

        Tarefa tarefa3 = new Tarefa("Tela principal", "Criar a tela principal");
        tarefa3.criarPrazoInicio("15", "10", "2023");
        tarefa3.criarPrazoFinal("23", "10", "2023");
        tarefa3.alocarMembro(maria);
        tarefa3.alocarMembro(joao);
        tarefa3.alocarMembro(pedro);
        tarefa3.alocarLider(marcos);


        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(tarefa1);
        tarefas.add(tarefa2);
        tarefas.add(tarefa3);


        projeto.setTarefas(tarefas);

        // Equipe ==================================================================================
        Equipe equipe1 = new Equipe("Os coda fofos");
        equipe1.setProjetos(listaProjetos);

        // ======================================= Testes ==========================================

        // tarefa2.removerMembro("2");
        tarefa1.iniciarTarefa();
        tarefa1.concluirTarefa();

        tarefa2.iniciarTarefa();
        tarefa2.concluirTarefa();

        tarefa3.removerLider();
        tarefa3.alocarLider(pedro);
        tarefa3.removerMembro("4");
        tarefa3.iniciarTarefa();
        tarefa3.concluirTarefa();

        // ======================================= Resultado =======================================
        System.out.println("======= Equipe: " + equipe1.getNome() + " =======\n");

        System.out.println("Projeto: " + projeto.getNome());
        System.out.println("     Descrição: " + projeto.getDescricao());
        System.out.println("     Prazo: " + projeto.getPrazo());
        System.out.println("     Membros do Projeto:\n" + "       " + equipe1.listarTodosMembrosDoProjeto() + "\n");

        System.out.println("+++++++ Tarefas +++++++\n");
        System.out.println("Tarefa: " + tarefa1.getNome() +
                "\n     Descrição: " + tarefa1.getDescricao() +
                "\n     Status: " + tarefa1.getStatus() + " - " + tarefa1.getDataConclusao() +
                "\n     Prazo Final: " + tarefa1.getPrazoFinal() +
                "\n     Lider: " + tarefa1.getLider().getNome() +
                "\n     Membros: " + tarefa1.listarTodosMembros() + "\n");
        System.out.println("----------------------------------------");

        System.out.println("Tarefa: " + tarefa2.getNome() +
                "\n     Descrição: " + tarefa2.getDescricao() +
                "\n     Status: " + tarefa2.getStatus() + " - " + tarefa2.getDataConclusao() +
                "\n     Prazo Final: " + tarefa2.getPrazoFinal() +
                "\n     Lider: " + tarefa2.getLider().getNome() +
                "\n     Membros: " + tarefa2.listarTodosMembros() + "\n");
        System.out.println("----------------------------------------");

        System.out.println("Tarefa: " + tarefa3.getNome() +
                "\n     Descrição: " + tarefa3.getDescricao() +
                "\n     Status: " + tarefa3.getStatus() + " - " + tarefa3.getDataConclusao() +
                "\n     Prazo Final: " + tarefa3.getPrazoFinal() +
                "\n     Lider: " + tarefa3.getLider().getNome() +
                "\n     Membros: " + tarefa3.listarTodosMembros() + "\n");
        System.out.println("----------------------------------------");

        System.out.println("Tarefas atrasadas:\n" +
                "       " + projeto.listarTarefasAtrasadas());
        System.out.println("----------------------------------------");

        System.out.printf("\nTarefas concluídas: %.2f%%\n", projeto.porcentagemTarefasConcluidas());

    }

}