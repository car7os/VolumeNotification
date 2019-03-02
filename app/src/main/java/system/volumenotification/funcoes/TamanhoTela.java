package system.volumenotification.funcoes;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class TamanhoTela extends Activity {

    private int largura;
    private int altura;
    private double polegadas;

    public TamanhoTela() {

        int altura;
        int largura;
        int densidade;


        DisplayMetrics tela = new DisplayMetrics();
        ((Activity)this).getWindowManager().getDefaultDisplay().getMetrics(tela);

        altura = tela.heightPixels;
        largura = tela.widthPixels;

        this.altura = altura;
        this.largura = largura;


        densidade = tela.densityDpi;

        double alt = (double)altura / (double) densidade;
        double larg = (double)largura / (double) densidade;

        double x = Math.pow(larg, 2);
        double y = Math.pow(alt,2);

        double polegadas = Math.sqrt(x*y);

        this.polegadas = polegadas;

    }

    public int getAltura(){
        return this.altura;
    }

    public int getLargura(){
        return this.largura;
    }

    public double getPolegadas() {
        return this.polegadas;
    }
}
