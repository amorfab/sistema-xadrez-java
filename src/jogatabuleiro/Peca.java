package jogatabuleiro;

public class Peca {
    private Tabuleiro tabuleiro;
    protected Posicao position;

    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.position = null;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
