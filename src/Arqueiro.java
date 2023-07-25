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

    public ArrayList<Posicao> possiveisMovimentoAtaques(Campo campo) {

        for (Posicao posicao : campo.getPosicoes()) {
            int indice = campo.getPosicoes().indexOf(posicao);
            if (this.getCor() == "Vermelho") {
                if (indice >= 50 && indice <= 53 ||
                        indice >= 56 && indice <= 59 ||
                        indice >= 60 && indice <= 63 ||
                        indice >= 66 && indice <= 69 ||
                        indice >= 70 && indice <= 73 ||
                        indice >= 76 && indice <= 79 ||
                        indice >= 80 && indice <= 83 ||
                        indice >= 86 && indice <= 89
                ) {

                    ataquePossiveis.add(posicao);
                } else {
                    if (indice >= 40 && indice <= 43 ||
                            indice >= 46 && indice <= 49 ||
                            indice >= 30 && indice <= 33 ||
                            indice >= 36 && indice <= 39 ||
                            indice >= 20 && indice <= 23 ||
                            indice >= 26 && indice <= 29 ||
                            indice >= 10 && indice <= 13 ||
                            indice >= 16 && indice <= 19
                    ) {

                        ataquePossiveis.add(posicao);

                    }

                }


            }


        }
        return ataquePossiveis;
    }

    @Override
    public  boolean atacar(Campo campo, Posicao posicaoAtacar) {
        possiveisMovimentoAtaques(campo);
        for(Posicao posicao:ataquePossiveis){
            if(posicao==posicaoAtacar){
                posicaoAtacar.getUnidade().setVida(getVida()-getDano());
                System.out.println(posicaoAtacar.getUnidade()+""+posicaoAtacar.getUnidade().getVida());
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Arqueiro  " ;
    }
}
