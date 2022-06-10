package edu.fiuba.algo3.modelo;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Posicion {
    private int x;
    private int y;

    public void trasladar(Posicion nueva) {
        this.x += nueva.x;
        this.y += nueva.y;
    }
    public Posicion(int x, int y)
    {
        this.x = x;
        this.y =y;
    }

    public boolean esMismaPosicion(Posicion unaPosicion)
    {
        return( this.x == unaPosicion.x && this.y == unaPosicion.y);
    }

    public Posicion siguiente(char unaDireccion)
    {
        Posicion siguiente = this;
        if(unaDireccion == 'w')
            siguiente.y+=1;
        if(unaDireccion == 's')
            siguiente.y-=1;
        if(unaDireccion == 'd')
            siguiente.x+=1;
        if(unaDireccion == 'a')
            siguiente.x-=1;
        return siguiente;
    }

}
