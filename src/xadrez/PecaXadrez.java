package xadrez;

import jogatabuleiro.Peca;
import jogatabuleiro.Posicao;
import jogatabuleiro.Tabuleiro;

public class PecaXadrez extends Peca {
    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }


}
