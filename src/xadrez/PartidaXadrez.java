package xadrez;

import jogatabuleiro.Posicao;
import jogatabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        this.tabuleiro = new Tabuleiro(8,8);
        SetupInicial();
    }

    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
            }
        }
        return mat;
    }

    private void SetupInicial(){
        tabuleiro.LugarDaPeca(new Torre(tabuleiro, Cor.BRANCA), new Posicao(2,1));
        tabuleiro.LugarDaPeca(new Rei(tabuleiro, Cor.PRETA), new Posicao(0,4));
        tabuleiro.LugarDaPeca(new Rei(tabuleiro, Cor.BRANCA), new Posicao(7,4));
    }
}
