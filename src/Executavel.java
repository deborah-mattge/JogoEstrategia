import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {

    static Campo campo = new Campo();
    static int jogadorAtual = 1;
    static String corJogador1 = "Azul";
    static String corJogador2 = "Vermelho";

    public static void main(String[] args) {
        mostrarTabuleiro();

        while (!fimDeJogo()) {
            System.out.println("Jogador " + jogadorAtual + " (" + obterCorJogador(jogadorAtual) + "), é a sua vez!");

            for (int jogada = 1; jogada <= 3; jogada++) {
                boolean jogadaValida = realizarJogada();

                if (!jogadaValida) {
                    System.out.println("Jogada inválida! Tente novamente.");
                    jogada--;
                } else {
                    mostrarTabuleiro();
                    if(fimDeJogo()){
                        break;
                    }
                }
            }

            jogadorAtual = (jogadorAtual == 1) ? 2 : 1;
        }

        System.out.println("Fim de jogo!");
        System.out.println("Jogador " + jogadorAtual + " (" + obterCorJogador(jogadorAtual) + ") venceu!");
    }

    public static boolean realizarJogada() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a posição da unidade que deseja usar (0-99): ");
        int posicaoOrigem = scanner.nextInt();


        Posicao origem = campo.getPosicoes().get(posicaoOrigem);


        Unidade unidade = origem.getUnidade();
        String opcao = " ";
        if (unidade != null && unidade.getCor().equals(obterCorJogador(jogadorAtual))) {
            if (unidade.possiveisMovimento(campo) != null) {
                System.out.print("Deseja mover (M) ou atacar (A)? ");
                opcao = scanner.next();
            } else {
                opcao = "A";
            }


            if (opcao.equalsIgnoreCase("M")) {
                System.out.print("Informe a posição para onde deseja mover a unidade (0-99): ");
                int posicaoDestino = scanner.nextInt();
                Posicao destino = campo.getPosicoes().get(posicaoDestino);
                if (unidade.mover(campo, destino)) {
                    System.out.println("Movimento realizado com sucesso!");
                    return true;
                } else {
                    System.out.println("Movimento inválido!");
                    return false;
                }
            } else if (opcao.equalsIgnoreCase("A")) {
                System.out.print("Informe a posição que deseja atacar (0-99): ");
                int posicaoAtaque = scanner.nextInt();

                Posicao alvo = campo.getPosicoes().get(posicaoAtaque);
                boolean ataqueValido = unidade.atacar(campo, alvo);

                if (ataqueValido) {
                    System.out.println("Ataque realizado com sucesso!");
                    System.out.println(alvo.getUnidade() + "" + alvo.getUnidade().getVida());

                    if (campo.getPosicoes().get(posicaoAtaque).getUnidade().getVida() <= 0) {
                        campo.getPosicoes().get(posicaoAtaque).setUnidade(null);
                    }
                    return true;
                } else {
                    System.out.println("Ataque inválido!");
                    return false;
                }
            }
        }

        return false;
    }

    public static boolean fimDeJogo() {
        boolean fortalezaAzulMorta = false;
        boolean fortalezaVermelhaMorta = false;

        for (Posicao posicao : campo.getPosicoes()) {
            Unidade unidade = posicao.getUnidade();
            if (unidade instanceof FortalezaEncantada && unidade.getVida() > 0) {
                if (unidade.getCor().equals("Vermelho")) {
                    fortalezaVermelhaMorta = true;
                } else if (unidade.getCor().equals("Azul")) {
                    fortalezaAzulMorta = true;
                }
            }
        }

        return !(fortalezaAzulMorta && fortalezaVermelhaMorta);
    }

    public static String obterCorJogador(int jogador) {
        return (jogador == 1) ? corJogador1 : corJogador2;
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
                        System.out.print("|          | ");
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