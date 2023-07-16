import java.util.ArrayList;

public abstract class Unidade {


    private Posicao posicao;
    private int vida;
    private int dano;
    private int movimento;
    private String cor;


    public Unidade(String cor) {
        this.cor = cor;


    }


    public boolean verificaUnidade(Posicao posicao, ArrayList<Posicao> possiveisMovimentos) {
        if (posicao.getUnidade() == null) {
            possiveisMovimentos.add(posicao);
            return false;

        }
        return true;
    }


    public boolean mover(Campo campo, Posicao posicao) {
        ArrayList<Posicao> possiveisPosicoes = possiveisMovimento(campo);

        for (Posicao posicaoPossivel : possiveisPosicoes) {
            if (posicaoPossivel.equals(posicao)) {
                //atribuindo a peça para nova posição no tabuleiro
                posicao.setUnidade(this);
                //removendo a peça da posição anterior
                this.posicao.setUnidade(null);
                //trocando a posição atual da peça
                this.posicao = posicao;
                return true;
            }
        }
        this.posicao = posicao;
        return false;

    }

    public boolean validaExtremidade(int posicaoNoTabuleiro) {
        if(posicaoNoTabuleiro%10==0 || posicaoNoTabuleiro-1%10==0) {
            return true;
        }
        return false;

    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public abstract ArrayList<Posicao> possiveisMovimento(Campo campo);
    public abstract ArrayList<Posicao>  possiveisMovimentoAtaques(Campo campo);


    public boolean atacar(Campo campo, Posicao posicaoAtacar){
        ArrayList<Posicao>ataquePossiveis= possiveisMovimentoAtaques(campo);
        for(Posicao posicao:ataquePossiveis){
            if(posicao==posicaoAtacar){
                posicaoAtacar.getUnidade().setVida(getVida()-getDano());
                return true;

            }
        }
        return false;
    }



    public Posicao getPosicao() {
        return posicao;
    }

    public String getCor() {
        return cor;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}