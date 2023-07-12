import java.util.ArrayList;

public class Executavel {

    static Campo campo = new Campo();

    public static void main(String[] args) {
        mostrarTabuleiro();
        Posicao posicao = campo.getPosicoes().get(90);
        Arqueiro arqueiro = (Arqueiro) posicao.getUnidade();
        arqueiro.possiveisMovimentoAtaques(campo);
        Posicao posicaoAtaque = campo.getPosicoes().get(73);



        boolean valida = arqueiro.atacar(campo, posicaoAtaque);
        System.out.println(posicaoAtaque.getUnidade().getVida());
        if (posicaoAtaque != null && valida && posicaoAtaque.getUnidade().getVida()<=0) {
            campo.getPosicoes().get(73).setUnidade(null);

        }


        mostrarTabuleiro();

    }
    public static void mostrarTabuleiro() {
        int pos = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (pos < campo.getPosicoes().size()) {
                    Unidade unidade = campo.getPosicoes().get(pos).getUnidade();
                    if (unidade != null) {
                        System.out.print("|" + unidade + "| ");
                    } else {
                        System.out.print("|        | ");
                    }
                    pos++;
                } else {
                    System.out.print("         ");
                }
            }
            System.out.println();
        }
        pos = 0;
    }

}
