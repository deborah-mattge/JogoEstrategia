import java.util.ArrayList;

public class FortalezaEncantada extends Unidade {
    private ArrayList<Posicao>ataquePossiveis=new ArrayList<>();

    public FortalezaEncantada( String cor, String poder ) {
        super(cor);
        this.setDano(3);
        this.setVida(8);

    }


    public ArrayList<Posicao> possiveisMovimentoAtaques(Campo campo) {

        for(Posicao posicao : campo.getPosicoes()) {
            int indice =campo.getPosicoes().indexOf(posicao);
            if(this.getCor()=="Azul"){
                if(indice>=12 && indice<=18 || indice>=2 &&  indice<=7  ) {
                    ataquePossiveis.add(posicao);
                }
            }
            if(this.getCor()=="Vermelho"){
                if(indice>=82 && indice<=87 || indice<=97 && indice>=92 ) {
                    ataquePossiveis.add(posicao);
                }
            }

        }
        return ataquePossiveis;
    }



    @Override
    public ArrayList<Posicao> possiveisMovimento(Campo campo) {
        return null;
    }

    @Override
    public String toString() {
        return "Fortaleza " ;
    }
}
