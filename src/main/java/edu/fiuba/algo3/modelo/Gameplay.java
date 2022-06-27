package edu.fiuba.algo3.modelo;

public class Gameplay {
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private BuilderPruebas builder;

  private boolean llegoAMeta;

  public Gameplay(BuilderPruebas unBuilder) {
    this.builder = unBuilder;
    this.llegoAMeta = false;
  }

  public void iniciarJuego(Vehiculo vehiculo) {
    this.vehiculoEnJuego = vehiculo;
    this.mapa = this.builder.crearGameplay();
  }


  public boolean jugar(String input) {
    int puntaje = this.vehiculoEnJuego.movimientos();
    char direccion = (input.toLowerCase()).charAt(0);
    try{
      this.mapa.avanzar(vehiculoEnJuego, direccion);
    }
    catch (LlegoAMetaException e)
    {
      this.llegoAMeta = true;
    }
    return(this.vehiculoEnJuego.movimientos() != puntaje);
  }

  public String posicionJugador()
  {
    return( this.vehiculoEnJuego.getPosicion().posicionAString());
  }

  public boolean llegoAMeta()
  {
    return this.llegoAMeta;
  }

  public int puntaje() {
    return this.vehiculoEnJuego.movimientos();
  }
}
