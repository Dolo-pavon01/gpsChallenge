package edu.fiuba.algo3.Modelo;

public class SorpresaNula  implements  Sorpresa{

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
