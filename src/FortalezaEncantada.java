import java.util.ArrayList;

public class FortalezaEncantada extends Unidade {
    private ArrayList<Posicao>ataquePossiveis=new ArrayList<>();

    public FortalezaEncantada( String cor, String poder ) {
        super(cor);
        this.setDano(3);
        this.setVida(8);

    }


    public ArrayList<Posicao> possiveisMovimentoAtaques(Campo campo) {
        int[] indices = { 2, 7, 12, 17};

        if(this.getCor().equals("Vermelho")){
            for (int i=0; i<indices.length; i++){
                indices[i]=indices[i]+80;
            }

        }

        for(Posicao posicao : campo.getPosicoes()) {
            int indice =campo.getPosicoes().indexOf(posicao);
            if(indice>=indices[0] && indice<=indices[1] || indice>=indices[2] &&  indice<=indices[3]  ) {
                ataquePossiveis.add(posicao);
            }


//            if(this.getCor().equals("Azul")){
//                if(indice>=12 && indice<=17 || indice>=2 &&  indice<=7  ) {
//                    ataquePossiveis.add(posicao);
//                }
//            }
//            if(this.getCor().equals("Vermelho")){
//                if(indice>=82 && indice<=87 || indice<=97 && indice>=92 ) {
//                    ataquePossiveis.add(posicao);
//                }
//            }

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
