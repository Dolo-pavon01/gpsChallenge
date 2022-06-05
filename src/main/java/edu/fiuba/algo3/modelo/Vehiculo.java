package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {
    protected int posicion;
    protected int movimientos;

    public Vehiculo() {
        this.posicion = 0;
        this.movimientos = 0;
    }

    public int movimientos() {
        return this.movimientos;
    }

    public int posicion() {
        return this.posicion;
    }

    public void mover(int nuevaPosicion, int movimientos) {
        this.posicion += nuevaPosicion;
        this.movimientos += movimientos;
    }
}
