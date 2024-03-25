package jogatabuleiro;

public class Peca {
    protected Posicao position;
    private Tabuleiro tabuleiro;

    public Peca(Posicao position) {
        this.tabuleiro = tabuleiro;
        this.position = null;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
