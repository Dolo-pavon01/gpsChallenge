package edu.fiuba.algo3.modelo;

public class Vehiculo {
    private TipoVehiculo tipo;
    private Posicion posicion;

    private int movimientos;

    public Vehiculo()
    {
        this.movimientos= 0;
    }
    public int pasarPor(IVisitor visitor)
    {
        this.tipo.pasarPor(visitor);
    }
    public int abrirSopresa(Sorpresa sorpresa)
    {
        return sorpresa.activar(this);
    }
    public void moverse(Posicion posicion) {
        this.posicion.trasladar(posicion);
    }
    Posicion getPosicion()
    {
        return this.posicion;
    };
}
