import java.util.ArrayList;

public class Arqueiro extends Unidade{
    public Arqueiro(String cor) {
        super(cor);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Campo campo) {
        return null;
    }

    @Override
    public void atacar(Campo campo, Posicao posicao) {

    }
}
