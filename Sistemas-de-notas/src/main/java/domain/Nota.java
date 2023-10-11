package domain;

import domain.infra.CalcularMedia;

public class Nota implements CalcularMedia {

    private float[] notas;

    public Nota(float[] notas) {
        this.notas = notas;
    }

    @Override
    public float mediaAritmetica() {
        float soma = 0;
        for (float nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }


    public float[] getNotas() {
        return notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }
}
