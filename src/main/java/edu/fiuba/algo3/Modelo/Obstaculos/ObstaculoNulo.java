package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto4x4;
import edu.fiuba.algo3.Modelo.Vehiculo.Moto;


public class ObstaculoNulo implements Obstaculo {


    @Override
    public String nombreObstaculo() {
        return "obstacucloNulo";
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
