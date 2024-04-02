package application;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PartidaXadrez partida = new PartidaXadrez();

        while (true){
            UI.printTabuleiro(partida.getPecas());
            System.out.println();
            System.out.print("Origem: ");
            PosicaoXadrez origem = UI.lerPosicaoXadrex(sc);

            System.out.println();
            System.out.print("Destino: ");
            PosicaoXadrez destino = UI.lerPosicaoXadrex(sc);

            PecaXadrez pecaCapturada = partida.executarMovimentoXadrez(origem, destino);

        }
    }
}
