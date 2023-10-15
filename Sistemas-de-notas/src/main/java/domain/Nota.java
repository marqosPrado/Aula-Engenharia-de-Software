package domain;

public class Nota {
    private double[] notas;

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public boolean validarNotas() {
        for (double nota : notas) {
            if (nota < 0 || nota > 10) {
                return false;
            }
        }
        return true;
    }
}
