import java.util.ArrayList;

public class Centauro extends Unidade{
    private ArrayList<Posicao>ataquePossiveis=new ArrayList<>();
    public Centauro(String cor) {
        super(cor);
        this.setDano(4);
        this.setVida(4);
    }

    public void possiveisMovimentoAtaques(Campo campo) {
        for(int i=0; i<campo.getPosicoes().size();i++){
            if(campo.getPosicoes().get(i-1)==this.getPosicao() && validaExtremidade(i)||
                    campo.getPosicoes().get(i+1)==this.getPosicao() && validaExtremidade(i)||
                campo.getPosicoes().get(i+10)==this.getPosicao() && validaExtremidade(i)||
                    campo.getPosicoes().get(i-10)==this.getPosicao() && validaExtremidade(i)
            ){
                ataquePossiveis.add(campo.getPosicoes().get(i));
            }
        }

    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Campo campo) {
        ArrayList<Posicao> possiveisMovimento=new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoCampo = campo.getPosicoes().indexOf(posicaoAtual);
        for(){
            if(verificaUnidade(possiveisMovimento.get()))
        }

        return possiveisMovimento;
    }

    @Override
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
}
