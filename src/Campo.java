import java.util.ArrayList;

public class Campo {
    private ArrayList<Posicao>posicoes=new ArrayList<>();
    Campo(){
        for(int i=0;i<100;i++){
            posicoes.add(new Posicao());
            if(i>=97 && i<=100){
                posicoes.get(i).setUnidade(new FortalezaEncantada("Vermelho","Fogo"));
            }
            if(i>=3 && i<=6){
                posicoes.get(i).setUnidade(new FortalezaEncantada("Azul", "Agua"));
            }

            if(i<=2 && i<=7 && i<9){
                posicoes.get(i).setUnidade(new Arqueiro("Vermelho"));
            }
            if(i<=99 && i>=97 || i<=92 && i>=90){
                posicoes.get(i).setUnidade(new Arqueiro("Azul"));
            }

        }


    }
    public void removerPeca(Posicao posicao){

    }

    public ArrayList<Posicao> getPosicoes() {

        return posicoes;
    }

    @Override
    public String toString() {
        return "Campo{" +
                "posicoes=" + posicoes +
                '}';
    }
}