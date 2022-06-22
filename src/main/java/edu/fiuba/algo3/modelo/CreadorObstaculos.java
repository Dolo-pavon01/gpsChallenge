package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class CreadorObstaculos implements Creador{

    public HashMap crear(int tamanioMapa)
    {
        HashMap obstaculos = new HashMap<>(10,70);
        for(int i = 1;i< tamanioMapa/3;i++)
        {
            Posicion p = Posicion.getPosicion(0,i);
            obstaculos.put(p,new Piquete());
        }
        for(int i = 2;i< tamanioMapa/3;i++)
        {
            Posicion p = Posicion.getPosicion(i,i);
            obstaculos.put(p,new ControlPolicial());
        }
        for(int i = 1;i< tamanioMapa/2;i++)
        {
            Posicion p = Posicion.getPosicion(i+1,i);
            obstaculos.put(p,new Pozo());
        }
        return obstaculos;
    }
}
