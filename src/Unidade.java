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

        if (possiveisPosicoes.contains(posicao)) {
            posicao.setUnidade(this);
            this.posicao.setUnidade(null);
            this.posicao = posicao;
            return true;
        } else {
            return false;
        }
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
                System.out.println(posicaoAtacar.getUnidade()+""+posicaoAtacar.getUnidade().getVida());
                System.out.println(this.getDano());
                posicaoAtacar.getUnidade().setVida(posicaoAtacar.getUnidade().getVida()-this.getDano());
                System.out.println(posicaoAtacar.getUnidade()+""+posicaoAtacar.getUnidade().getVida());
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