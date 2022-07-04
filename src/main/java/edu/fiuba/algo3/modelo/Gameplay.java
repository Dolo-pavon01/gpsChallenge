package edu.fiuba.algo3.modelo;

public class Gameplay {
  private Vehiculo vehiculo;
  private MapaFactory mapaFactory;
  private Mapa mapa;
  private boolean llegoAMeta;

  public Gameplay(MapaFactory mapaFactory) {
    this.mapaFactory = mapaFactory;
    this.llegoAMeta = false;
  }

  public Mapa getMapa() {
    return this.mapa;
  }

  public Mapa iniciarJuego(Vehiculo vehiculo) {
    this.vehiculo = vehiculo;
    this.mapa = this.mapaFactory.crearGameplay();
    return this.mapa;
  }

  public boolean jugar(char direccion) {
    int puntaje = this.vehiculo.movimientos();
    try {
      this.mapa.avanzar(this.vehiculo, direccion);
    } catch (LlegoAMetaException e) {
      this.llegoAMeta = true;
    }
    return (this.vehiculo.movimientos() != puntaje);
  }

  public String posicionJugador() {
    return (this.vehiculo.getPosicion().posicionAString());
  }

  public boolean llegoAMeta() {
    return this.llegoAMeta;
  }

  public int puntaje() {
    return this.vehiculo.movimientos();
  }
}
