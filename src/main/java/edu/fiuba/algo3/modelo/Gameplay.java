package edu.fiuba.algo3.modelo;

public class Gameplay {
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private BuilderPruebas builder;

  public Gameplay(BuilderPruebas unBuilder) {
    this.builder = unBuilder;
  }

  public void iniciarJuego(Vehiculo vehiculo) {
    this.vehiculoEnJuego = vehiculo;
    this.mapa = this.builder.crearGameplay();
  }


  public boolean jugar(char input) {
    int puntaje = this.vehiculoEnJuego.movimientos();
    this.mapa.avanzar(vehiculoEnJuego, input);
    return(this.vehiculoEnJuego.movimientos() != puntaje);
  }

  public String posicionJugador()
  {
    return( this.vehiculoEnJuego.getPosicion().posicionAString());
  }

  public int puntaje() {
    return this.vehiculoEnJuego.movimientos();
  }
}
