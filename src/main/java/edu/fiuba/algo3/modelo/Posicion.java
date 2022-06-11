package edu.fiuba.algo3.modelo;

import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Posicion {
    private int x;
    private int y;
    private static List<Posicion> instances = new ArrayList<Posicion>();

    public void trasladar(Posicion nueva)
    {
        getPosicion(nueva.x,nueva.y);
    }
    private Posicion(int x, int y)
    {
        this.x = x;
        this.y =y;
        instances.add(this);
    }
    public static Posicion getPosicion(int x, int y)
    {
        for (Posicion i: instances) {
            if(i.x == x && i.y == y)
                return i;
        }
        return new Posicion(x,y);
    }


    public Posicion siguiente(char unaDireccion)
    {
        int x = this.x;
        int y = this.y ;

        if(unaDireccion == 'w')
           y+=1;
        if(unaDireccion == 's')
            y-=1;
        if(unaDireccion == 'd')
            x+=1;
        if(unaDireccion == 'a')
            x-=1;
        return getPosicion(x,y);
    }

}
