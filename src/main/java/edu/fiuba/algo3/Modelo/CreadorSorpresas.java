package edu.fiuba.algo3.Modelo;

import java.util.HashMap;

public class CreadorSorpresas implements Creador{

    public HashMap crear(int alto, int ancho)
    {
        HashMap sorpresas = new HashMap<>(10,70);
        for(int i=0;i< ancho;i++)
        {
            for(int j=0;j<alto;j++)
            {
                Posicion p = Posicion.getPosicion(i,j);
                sorpresas.put(p,new SorpresaNula());
            }
        }

        return sorpresas;
    }
}
