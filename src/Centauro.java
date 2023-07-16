import java.util.ArrayList;

public class Centauro extends Unidade{

    public Centauro(String cor) {
        super(cor);
        this.setDano(4);
        this.setVida(4);
    }

    public ArrayList<Posicao> possiveisMovimentoAtaques(Campo campo) {
        ArrayList<Posicao> ataquePossiveis=new ArrayList<>();
        for(Posicao posicao : campo.getPosicoes()){
            int i =campo.getPosicoes().indexOf(posicao);


            if(i > 0 && campo.getPosicoes().get(i - 1).equals(this.getPosicao()) ||
                    i < campo.getPosicoes().size() - 1 && campo.getPosicoes().get(i + 1).equals(this.getPosicao()) ||
                    i < campo.getPosicoes().size() - 10 && campo.getPosicoes().get(i + 10).equals(this.getPosicao()) ||
                    i >= 10 && campo.getPosicoes().get(i - 10).equals(this.getPosicao())
            ){
                ataquePossiveis.add(campo.getPosicoes().get(i));
            }
        }
        return  ataquePossiveis;

    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Campo campo) {
        Posicao posicaoAtual = this.getPosicao();

        int posicaoNoTabuleiro = campo.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (int i = posicaoNoTabuleiro + 10;
             i < posicaoNoTabuleiro+40;
             i += 10) {
            if (verificaUnidade(campo.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }

        for (int i = posicaoNoTabuleiro - 10;
             i >= 0;
             i -= 10) {
            if(posicaoNoTabuleiro-40==i){
                break;
            }else {


                if (verificaUnidade(campo.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                    break;
                }
            }

        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ? -1 : posicaoNoTabuleiro + 1);
             i < campo.getPosicoes().size();
             i++) {

            if (verificaUnidade(campo.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? -1 : posicaoNoTabuleiro - 1);
             i >= 0;
             i--) {

            if (verificaUnidade(campo.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }


        return possiveisMovimentos;
    }



    @Override
    public String toString() {
        return "Centauro  "
                ;
    }
}
