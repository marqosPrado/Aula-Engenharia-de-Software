import domain.*;
import service.CriarNotasAluno;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("============ Sistema de Matrícula e Notas ============");

        Matricula aluno1 = new Matricula(new Aluno("1111", "Julio Cocielo"), LocalDateTime.now());
        Matricula aluno2 = new Matricula(new Aluno("2222", "Jean"), LocalDateTime.now());
        Matricula aluno3 = new Matricula(new Aluno("3333", "Igor O Barba"), LocalDateTime.now());
        Matricula aluno4 = new Matricula(new Aluno("4444", "Sergião Foguetes"), LocalDateTime.now());

        List<Matricula> listaMatriculaADS = new ArrayList<>();
        listaMatriculaADS.add(aluno1);
        listaMatriculaADS.add(aluno2);
        listaMatriculaADS.add(aluno3);
        listaMatriculaADS.add(aluno4);

        Aula es2 = new Aula("Engenharia de Software", 10);

        Curso ads = new Curso("ADS", "Análise e Desenvolvimento de Sistemas", listaMatriculaADS, es2);

        CriarNotasAluno criarNotasAluno = new CriarNotasAluno();

        double[] notas = {10, 10, 10};
        Nota nota = new Nota();
        nota.setNotas(notas);
        aluno1.setNota(nota);

        aluno2.setNota(criarNotasAluno.gerarNotasAleatorias());
        aluno3.setNota(criarNotasAluno.gerarNotasAleatorias());
        aluno4.setNota(criarNotasAluno.gerarNotasAleatorias());

        List<Presenca> listaPresenca1 = new ArrayList<>();
        listaPresenca1.add(Presenca.PRESENTE);
        listaPresenca1.add(Presenca.PRESENTE);
        listaPresenca1.add(Presenca.FALTA);
        listaPresenca1.add(Presenca.FALTA);
        listaPresenca1.add(Presenca.FALTA);
        listaPresenca1.add(Presenca.FALTA);
        listaPresenca1.add(Presenca.FALTA);
        listaPresenca1.add(Presenca.FALTA);

        aluno1.setPresenca(listaPresenca1);

        List<Presenca> listaPresenca2 = new ArrayList<>();
        listaPresenca2.add(Presenca.PRESENTE);
        listaPresenca2.add(Presenca.PRESENTE);
        listaPresenca2.add(Presenca.PRESENTE);
        listaPresenca2.add(Presenca.FALTA);
        listaPresenca2.add(Presenca.FALTA);
        listaPresenca2.add(Presenca.FALTA);
        listaPresenca2.add(Presenca.PRESENTE);
        listaPresenca2.add(Presenca.FALTA);

        aluno2.setPresenca(listaPresenca2);

        double notaGeral = ads.calcularMediaGeral();
        String notaFormatada = String.format("%.2f", notaGeral);

        System.out.println("Nota geral da sala: " + notaFormatada);
        ads.mostrarAlunosReprovados();
    }
}
