package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class CreadorSorpresas implements Creador{

    public HashMap crear(int tamanioMapa)
    {
        HashMap sorpresas = new HashMap<>(10,70);
        for(int i = 2;i< tamanioMapa/5;i++)
        {
            Posicion p =Posicion.getPosicion(i,i+1);
            sorpresas.put(p,new SorpresaCambioVehiculo());
        }
        for(int i = 3;i< tamanioMapa/5;i++)
        {
            Posicion p =Posicion.getPosicion(i,i-1);
            sorpresas.put(p,new SorpresaFavorable());
        }
        for(int i = 4;i< tamanioMapa/5;i++)
        {
            Posicion p =Posicion.getPosicion(i,i+2);
            sorpresas.put(p,new SorpresaDesfavorable());
        }
        return sorpresas;
    }
}
