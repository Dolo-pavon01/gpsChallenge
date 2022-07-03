package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class CreadorSorpresas implements Creador{

    public HashMap crear(int largo, int ancho)
    {
        HashMap sorpresas = new HashMap<>(10,70);
        for(int i=0;i< largo;i++)
        {
            for(int j=0;j<ancho;j++)
            {
                Posicion p = Posicion.getPosicion(i,j);
                sorpresas.put(p,new SorpresaNula());
            }
        }

        return sorpresas;
    }
}
