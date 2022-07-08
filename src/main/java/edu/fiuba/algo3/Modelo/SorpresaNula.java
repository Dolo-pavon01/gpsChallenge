package edu.fiuba.algo3.Modelo;

public class SorpresaNula  implements  Sorpresa{

    public String getNombre()
    {
        return "sopresaNula";
    }
    @Override
    public void activar(Vehiculo vehiculo) {
        return;
    }
}
