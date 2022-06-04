package edu.fiuba.algo3.modelo;

public class Moto {
    private String identificador;
    private int posicion;
    private int movimientos;

    public Moto(String identificador) {
        this.identificador = identificador;
        this.posicion = 0;
        this.movimientos = 0;
    }

    public int movimientos() {
        return this.movimientos;
    }

    public int posicion() {
        return this.posicion;
    }

    public void actualizaPosicion(int proximaPosicion) {
       this.posicion += proximaPosicion;
    }

    public void actualizarCantidadMovimientos(int movimientos) {
        this.movimientos += movimientos;
    }
}
