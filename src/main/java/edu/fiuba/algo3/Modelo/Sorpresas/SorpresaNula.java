package edu.fiuba.algo3.Modelo.Sorpresas;

import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;

public class SorpresaNula  implements Sorpresa {

    @Override
    public String nombreSorpresa()
    {
        return "sopresaNula";
    }
    @Override
    public void activar(Vehiculo vehiculo) {
        return;
    }
}
