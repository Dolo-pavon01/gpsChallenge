package edu.fiuba.algo3.modelo;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Posicion {
    private int x;
    private int y;

    public void trasladar(int x, int y) {
        this.x += x;
        this.y += y;
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
    public double distancia(Posicion unaPosicion) {
        double p1 = pow(this.x - unaPosicion.x, 2);
        double p2 = pow(this.y - unaPosicion.y, 2);
        double p3 = sqrt(p1+p2);
        return p3;
    }


}
