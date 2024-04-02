package xadrez;

import jogotabuleiro.Peca;
import jogotabuleiro.Posicao;
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
    public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino){
        Posicao origem = posicaoOrigem.paraPosicao();
        Posicao destino = posicaoDestino.paraPosicao();
        validarPosicaoOrigem(origem);
        Peca pecaCapturada = facaMovimento(origem, destino);
        return (PecaXadrez)pecaCapturada;
    }

    private void validarPosicaoOrigem(Posicao posicao){
         if (!tabuleiro.ExisteUmaPeca(posicao)){
             throw new XadrezException("Nao exite peca na posicao de origem");
         }
    }

    private  Peca facaMovimento(Posicao origem, Posicao destino){
        Peca p = tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.LugarDaPeca(p, destino);
        return pecaCapturada;
    }

    private void LugarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.LugarDaPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
    }
    private void SetupInicial(){

        LugarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCA));
        LugarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCA));
        LugarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCA));
        LugarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCA));
        LugarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCA));
        LugarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCA));

        LugarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETA));
        LugarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETA));
        LugarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETA));
        LugarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETA));
        LugarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETA));
        LugarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETA));
    }
}
