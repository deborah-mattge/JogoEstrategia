import java.util.ArrayList;

public class Campo {
    private ArrayList<Posicao>posicoes=new ArrayList<>();
    Campo(){
        for(int i=0;i<100;i++){
            posicoes.add(new Posicao());
            if(i>=93 && i<=96){
                posicoes.get(i).setUnidade(new FortalezaEncantada("Vermelho","Fogo"));
                posicoes.get(i).getUnidade().setPosicao(posicoes.get(i));

            }
            if(i>=3 && i<=6){
                posicoes.get(i).setUnidade(new FortalezaEncantada("Azul", "Agua"));
                posicoes.get(i).getUnidade().setPosicao(posicoes.get(i));

            }


            if(i<=9 && i>=7 || i<=2 && i>=0){
                posicoes.get(i).setUnidade(new Arqueiro("Azul"));
                posicoes.get(i).getUnidade().setPosicao(posicoes.get(i));

            }
            if(i<=99 && i>=97 || i<=92 && i>=90){
                posicoes.get(i).setUnidade(new Arqueiro("Vermelho"));
                posicoes.get(i).getUnidade().setPosicao(posicoes.get(i));

            }

            if( i>=83 && i<=86 ){
                posicoes.get(i).setUnidade(new Centauro("Vermelho"));
                posicoes.get(i).getUnidade().setPosicao(posicoes.get(i));

            }
            if( i>=13 && i<=16 ){
                posicoes.get(i).setUnidade(new Centauro("Azul"));
                posicoes.get(i).getUnidade().setPosicao(posicoes.get(i));


            }
            if(i==81 || i==88){
                posicoes.get(i).setUnidade((new Mago("Vermelho", "fogo") ));
            }
            if(i==11 || i==18){
                posicoes.get(i).setUnidade((new Mago("Azul", "fogo") ));
            }
            if(i==80 || i==70 || i==71){
                posicoes.get(i).setUnidade((new Mago("Vermelho", "agua") ));
            }
            if(i==20 || i==10 || i==21){
                posicoes.get(i).setUnidade((new Mago("Azul", "agua") ));
            }
            if(i==89 || i==79 || i==78){
                posicoes.get(i).setUnidade((new Mago("Vermelho", "terra") ));
            }
            if(i==29 || i==19 || i==28){
                posicoes.get(i).setUnidade((new Mago("Azul", "terra") ));
            }
            if(i==82 || i==72 || i==87 || i==77 ){
                posicoes.get(i).setUnidade((new Mago("Vermelho", "ar") ));
            }
            if(i==22 || i==12 || i==27 || i==17 ){
                posicoes.get(i).setUnidade((new Mago("Azul", "ar") ));
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