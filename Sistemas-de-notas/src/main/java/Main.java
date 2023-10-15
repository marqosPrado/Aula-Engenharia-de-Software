import domain.*;
import service.CriarNotasAluno;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("============ Sistema de Matrícula e Notas ============");

        Scanner scanner = new Scanner(System.in);

        System.out.println("============ Cadastro de Curso ============");

        System.out.print("Digite a sigla do curso: ");
        String siglaCurso = scanner.nextLine();
        System.out.print("Digite o nome do curso: ");
        String nomeCurso = scanner.nextLine();

        System.out.println("============ Cadastro de Aula ============");

        int numeroTotalAulas = 0;
        System.out.println("Digite o titulo da aula: ");
        String tituloAula = scanner.nextLine();

        while (numeroTotalAulas <= 0) {
            System.out.print("Digite o número total de aulas (deve ser um número inteiro positivo): ");
            try {
                numeroTotalAulas = Integer.parseInt(scanner.nextLine());
                if (numeroTotalAulas <= 0) {
                    System.out.println("Número de aulas deve ser positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido para o número de aulas.");
            }
        }

        Aula aula = new Aula(tituloAula, numeroTotalAulas);

        List<Matricula> listaMatricula = new ArrayList<>();

        System.out.println("============ Cadastro de Alunos ============");
        while (true) {
            System.out.print("Digite o RA do aluno (ou digite 'sair' para encerrar): ");
            String ra = scanner.nextLine();

            if (ra.equals("sair")) {
                break;
            }

            System.out.print("Digite o nome do aluno: ");
            String nomeAluno = scanner.nextLine();

            Matricula matricula = new Matricula(new Aluno(ra, nomeAluno), LocalDateTime.now());

            // Cadastrar notas
            CriarNotasAluno criarNotasAluno = new CriarNotasAluno();
            Nota notas;
            do {
                notas = criarNotasAluno.gerarNotasAleatorias();
                if (!notas.validarNotas()) {
                    System.out.println("Notas inválidas. As notas devem estar no intervalo de 0 a 10.");
                }
            } while (!notas.validarNotas());

            matricula.setNota(notas);

            // Cadastrar presenças
            List<Presenca> listaPresenca = new ArrayList<>();
            int aulaNumero = 1;

            while (aulaNumero <= numeroTotalAulas) {
                System.out.print("Aula " + aulaNumero + ": ");
                String presencaStr = scanner.nextLine();
                if (presencaStr.equalsIgnoreCase("P") || presencaStr.equalsIgnoreCase("F")) {
                    Presenca presenca = presencaStr.equalsIgnoreCase("P") ? Presenca.PRESENTE : Presenca.FALTA;
                    listaPresenca.add(presenca);
                    aulaNumero++;
                } else {
                    System.out.println("Input inválido. Digite 'P' para presente ou 'F' para falta.");
                }
            }
            matricula.setPresenca(listaPresenca);

            listaMatricula.add(matricula);
        }

        Curso curso = new Curso(siglaCurso, nomeCurso, listaMatricula, aula);

        System.out.println("Nota geral da sala: " + curso.calcularMediaGeral());
        curso.mostrarAlunosReprovados();
    }
}
