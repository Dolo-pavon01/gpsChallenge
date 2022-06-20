package edu.fiuba.algo3.modelo;

public class Gameplay {
    private Vehiculo vehiculoEnJuego;
    private Mapa mapa;
    private BuilderPruebas builder;
    public Gameplay(BuilderPruebas unBuilder)
    {
        this.builder = unBuilder;
    }
    public void iniciarJuego(Vehiculo unVehiculo)
    {
        this.vehiculoEnJuego = unVehiculo;
        this.mapa = this.builder.crearGameplay();
    }

    public void jugar(char input)
    {
        this.mapa.avanzar(vehiculoEnJuego,input);
    }
    public int puntaje()
    {
        return this.vehiculoEnJuego.movimientos();
    }
}
