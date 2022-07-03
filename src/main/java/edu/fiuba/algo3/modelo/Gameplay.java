package edu.fiuba.algo3.modelo;

public class Gameplay {
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private MapaFactory builder;

  private boolean llegoAMeta;

  public Gameplay(MapaFactory unBuilder) {
    this.builder = unBuilder;
    this.llegoAMeta = false;
  }

  public Mapa getMapa() {
    return this.mapa;
  }

  public Mapa iniciarJuego(Vehiculo vehiculo) {
    this.vehiculoEnJuego = vehiculo;
    this.mapa = this.builder.crearGameplay();
    return this.mapa;
  }

  public boolean jugar(char input) {
    int puntaje = this.vehiculoEnJuego.movimientos();
    try {
      this.mapa.avanzar(vehiculoEnJuego, input);
    } catch (LlegoAMetaException e) {
      this.llegoAMeta = true;
    }
    return (this.vehiculoEnJuego.movimientos() != puntaje);
  }

  public String posicionJugador() {
    return (this.vehiculoEnJuego.getPosicion().posicionAString());
  }

  public boolean llegoAMeta() {
    return this.llegoAMeta;
  }

  public int puntaje() {
    return this.vehiculoEnJuego.movimientos();
  }
}
