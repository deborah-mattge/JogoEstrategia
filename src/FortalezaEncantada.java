import java.util.ArrayList;

public class FortalezaEncantada extends Unidade {
    private ArrayList<Posicao>ataquePossiveis=new ArrayList<>();

    public FortalezaEncantada( String cor, String poder ) {
        super(cor);
        this.setDano(3);
        this.setVida(9);

    }


    public void possiveisMovimentoAtaques(Campo campo) {

        for(Posicao posicao : campo.getPosicoes()) {
            int indice =campo.getPosicoes().indexOf(posicao);
            if(indice>=12 && indice<=18 && validaExtremidade(campo.getPosicoes().indexOf(posicao))||
                    indice==2 && validaExtremidade(campo.getPosicoes().indexOf(posicao)) ||
                            indice==7 && validaExtremidade(campo.getPosicoes().indexOf(posicao)) ) {

                ataquePossiveis.add(posicao);
            }
            if(indice>=82 && indice<=87 && validaExtremidade(campo.getPosicoes().indexOf(posicao)) ||
                    indice==97 && validaExtremidade(campo.getPosicoes().indexOf(posicao)) ||
                    indice==92 && validaExtremidade(campo.getPosicoes().indexOf(posicao))) {
                ataquePossiveis.add(posicao);
            }
        }

    }


    public boolean atacar(Campo campo, Posicao posicaoAtacar) {
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
    public ArrayList<Posicao> possiveisMovimento(Campo campo) {
        return null;
    }

    @Override
    public String toString() {
        return "Fortaleza" ;
    }
}
