package exceptions;

public class MembroNaoEncontrado extends RuntimeException {
    public MembroNaoEncontrado(String message) {
        super(message);
    }
}
