import domain.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Aluno aluno = new Aluno("1234", "Marcos");

        List<Nota> listaNotas = new ArrayList<>();
        float[] notas = {10, 10, 10};
        Nota nota = new Nota(notas);
        listaNotas.add(nota);

        List<Matricula> listaMatriculas = new ArrayList<>();
        Matricula matricula = new Matricula(aluno, listaNotas);
        listaMatriculas.add(matricula);

        List<Aula> listaAulas = new ArrayList<>();
        Aula aula = new Aula("Engenharia de Software", listaMatriculas);
        listaAulas.add(aula);

        Curso curso = new Curso("ADS", "Análise e Desenvolvimento de Sistemas", listaMatriculas, listaAulas);
        System.out.println(curso.getMatriculas().get(0).getAluno().getNome());
        System.out.println(curso.getAulas().get(0).getTitulo());
        System.out.println(curso.getMatriculas().get(0).obterMedia());

    }

}
