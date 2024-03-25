package xadrez;

import jogotabuleiro.Tabuleiro;
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
    private void LugarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.LugarDaPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
    }
    private void SetupInicial(){
        LugarNovaPeca('b', 6 , new Torre(tabuleiro, Cor.BRANCA));
        LugarNovaPeca('e',8 , new Rei(tabuleiro, Cor.PRETA));
        LugarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCA));
    }
}
