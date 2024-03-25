package jogotabuleiro;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1){
            throw new TabuleiroException("Erro criando o tabuleiro: E necessario que haja ao menos 1 linha e 1 coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca (int linha, int coluna){
        if (!ExistePosicao(linha, coluna)){
            throw new TabuleiroException("Posicao nao encontrada no tabuleiro");
        }
        return pecas[linha][coluna];
    }
    public Peca peca (Posicao posicao){
        if (!ExistePosicao(posicao)){
            throw new TabuleiroException("Posicao nao encontrada no tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void LugarDaPeca (Peca peca, Posicao posicao){
        if (ExisteUmaPeca(posicao)){
            throw new TabuleiroException("Ja existe uma peca na posicao " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.position = posicao;
    }

    private boolean ExistePosicao(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    public boolean ExistePosicao(Posicao posicao){
        return ExistePosicao(posicao.getLinha(), posicao.getColuna());
    }

    public boolean ExisteUmaPeca(Posicao posicao){
        if (!ExistePosicao(posicao)){
            throw new TabuleiroException("Posicao nao encontrada no tabuleiro");
        }
        return peca(posicao) != null;
    }

}
