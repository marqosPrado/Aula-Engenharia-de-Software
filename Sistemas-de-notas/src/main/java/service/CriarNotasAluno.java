package service;

import domain.Nota;

import java.util.Random;

public class CriarNotasAluno {

    public Nota gerarNotasAleatorias() {
        Nota nota = new Nota();
        Random random = new Random();
        double[] notas = new double[3];

        for (int i = 0; i < 3; i++) {
            double value = random.nextDouble() * 10; // Gere notas aleatórias entre 0 e 10
            notas[i] = value;
        }
        nota.setNotas(notas);
        return nota;
    }
}
