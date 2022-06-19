package edu.fiuba.algo3.modelo;

public class Gameplay {
    private Vehiculo vehiculoEnJuego;
    private Grilla grilla;
    private BuilderPruebas builder;
    public Gameplay(BuilderPruebas unBuilder)
    {
        this.builder = unBuilder;
    }
    public void iniciarJuego(Vehiculo unVehiculo)
    {
        this.vehiculoEnJuego = unVehiculo;
        this.grilla = this.builder.crearGameplay();
    }

    public void jugar(char input)
    {
        this.grilla.avanzar(vehiculoEnJuego,input);
    }
    public int puntaje()
    {
        return this.vehiculoEnJuego.movimientos();
    }
}
