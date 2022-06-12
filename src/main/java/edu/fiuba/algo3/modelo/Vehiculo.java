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
    public void abrirSopresa(Sorpresa sorpresa)
    {
         this.movimientos *= sorpresa.activar();
    }
    public void moverse(Posicion posicion) {
        this.posicion.trasladar(posicion);
    }
    Posicion getPosicion()
    {
        return this.posicion;
    };
}
