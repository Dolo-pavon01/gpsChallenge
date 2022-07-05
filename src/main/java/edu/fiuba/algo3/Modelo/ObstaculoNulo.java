package edu.fiuba.algo3.Modelo;

public class ObstaculoNulo implements Obstaculo {


    @Override
    public String nombreObstaculo() {
        return null;
    }

    @Override
    public int visit(Moto moto) {
        return 0;
    }

    @Override
    public int visit(Auto4x4 auto4x4) {
        return 0;
    }

    @Override
    public int visit(Auto auto) {
        return 0;
    }
}
