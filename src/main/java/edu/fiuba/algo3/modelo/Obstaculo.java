package edu.fiuba.algo3.modelo;

public abstract class Obstaculo {
    protected int posicion;
    protected String nombreObstaculo;

    public String getNombre() {
        return this.nombreObstaculo;
    }

    public abstract int penalizar(int posicion);

}
