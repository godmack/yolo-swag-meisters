package excecoes;

public class EntidadeNaoExistenteException extends Exception {

    public EntidadeNaoExistenteException() {
    }

    public EntidadeNaoExistenteException(String msg) {
        super(msg);
    }
}
