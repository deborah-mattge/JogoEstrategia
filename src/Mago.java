import java.util.ArrayList;

public class Mago extends Unidade {
    private String poder;

    public Mago(String cor, String poder) {
        super(cor);
        setPoder(poder);
    }

    public ArrayList<Posicao> possiveisMovimentoAtaques(Campo campo) {
        ArrayList<Posicao> ataquePossiveis=new ArrayList<>();
        for(Posicao posicao : campo.getPosicoes()){
            int i =campo.getPosicoes().indexOf(posicao);


            if(i > 0 && campo.getPosicoes().get(i - 1).equals(this.getPosicao()) ||
                    i < campo.getPosicoes().size() - 1 && campo.getPosicoes().get(i + 1).equals(this.getPosicao()) ||
                    i < campo.getPosicoes().size() - 10 && campo.getPosicoes().get(i + 10).equals(this.getPosicao()) ||
                    i >= 10 && campo.getPosicoes().get(i - 10).equals(this.getPosicao())
            ){
                ataquePossiveis.add(campo.getPosicoes().get(i));
            }
        }
        return  ataquePossiveis;

    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Campo campo) {
        Posicao posicaoAtual = this.getPosicao();

        int posicaoNoTabuleiro = campo.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
//        for (int i = posicaoNoTabuleiro - 20;
//             i < posicaoNoTabuleiro+40 ;
//             i += 10) {
//
//            if(i<campo.getPosicoes().size() && i>0 ){
//                if (verificaUnidade(campo.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
//                    break;
//                }
//            }
//
//        }

        for (int i = posicaoNoTabuleiro + 10;
             i < posicaoNoTabuleiro+30 ;
             i += 10) {
            if(i<campo.getPosicoes().size()){
                if (verificaUnidade(campo.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                    break;
                }
            }

        }

        for (int i = posicaoNoTabuleiro - 10;
             i >= 0;
             i -= 10) {
            if(i<campo.getPosicoes().size()) {
                if (posicaoNoTabuleiro - 30 == i) {
                    break;
                } else {


                    if (verificaUnidade(campo.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                        break;
                    }
                }
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ? campo.getPosicoes().size() : posicaoNoTabuleiro + 1);
             i < campo.getPosicoes().size();
             i++) {
            if (i < posicaoNoTabuleiro + 3){
                if (i < campo.getPosicoes().size()) {
                    if (verificaUnidade(campo.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                        break;
                    }
                }
        }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? campo.getPosicoes().size() : posicaoNoTabuleiro - 1);
             i >= 0;
             i--) {
            if(i>posicaoNoTabuleiro-3) {
                if (i < campo.getPosicoes().size()) {
                    if (verificaUnidade(campo.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                        break;
                    }
                }
            }
        }


        System.out.println(possiveisMovimentos);
        return possiveisMovimentos;
    }


    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        switch (poder){
            case "fogo":
                poder="fogo";
                setDano(3);
                break;
            case "agua":
                poder="agua";
                setDano(2);
                break;
            case "terra":
                poder="terra";
                setDano(3);
                break;
            case "ar":
                poder="ar";
                setDano(1);
                break;

        }
        this.poder = poder;
    }

    @Override
    public String toString() {
        if(this.poder.equals("agua")){
            return "Mago-Agua ";
        }
        if(this.poder.equals("fogo")){
            return "Mago-Fogo ";
        }
        if(this.poder.equals("terra")){
            return "Mago-Terra";
        }
        if(this.poder.equals("ar")){
            return "  Mago-Ar ";
        }
        return "Mago " + poder;
    }
}
