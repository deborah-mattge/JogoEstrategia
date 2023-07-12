import java.util.ArrayList;

public class Arqueiro extends Unidade{
    private ArrayList<Posicao>ataquePossiveis=new ArrayList<>();
    public Arqueiro(String cor) {
        super(cor);
        this.setDano(3);
        this.setVida(2);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Campo campo) {
        return null;
    }

    public void possiveisMovimentoAtaques(Campo campo) {

        for(Posicao posicao : campo.getPosicoes()) {
            int indice =campo.getPosicoes().indexOf(posicao);
            if(indice>=50 && indice<=53 && validaExtremidade(campo.getPosicoes().indexOf(posicao))||
                    indice>=56 && indice<=59 && validaExtremidade(campo.getPosicoes().indexOf(posicao)) ||
                    indice>=60 && indice<=63 && validaExtremidade(campo.getPosicoes().indexOf(posicao))||
                    indice>=66 && indice<=69 && validaExtremidade(campo.getPosicoes().indexOf(posicao))||
                    indice>=70 && indice<=73 && validaExtremidade(campo.getPosicoes().indexOf(posicao))||
                    indice>=76 && indice<=79  && validaExtremidade(campo.getPosicoes().indexOf(posicao))||
                    indice>=80 && indice<=83  && validaExtremidade(campo.getPosicoes().indexOf(posicao))||
                    indice>=86  && indice<=89 && validaExtremidade(campo.getPosicoes().indexOf(posicao))
            ){

                ataquePossiveis.add(posicao);
            }

        }

    }

    @Override
    public  boolean atacar(Campo campo, Posicao posicaoAtacar) {
        possiveisMovimentoAtaques(campo);
        for(Posicao posicao:ataquePossiveis){
            if(posicao==posicaoAtacar){
                posicaoAtacar.getUnidade().setVida(getVida()-getDano());
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Arqueiro" ;
    }
}
