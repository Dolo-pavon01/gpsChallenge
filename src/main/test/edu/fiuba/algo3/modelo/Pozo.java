package edu.fiuba.algo3.modelo;

public class Pozo {
    private int posicion;

    public Pozo(int posicion) {
        this.posicion = posicion;
    }

    public int aplicarPenalizacion(int proximaPosicion) {
        if (this.posicion == proximaPosicion) {
            return 3;
        }
        return 0;
    }
}
