package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.visuales.VistaMapa;

public class Gameplay {
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private MapaFactory builder;

  private boolean llegoAMeta;

  public Gameplay(MapaFactory unBuilder) {
    this.builder = unBuilder;
    this.llegoAMeta = false;
  }

  public VistaMapa crearVistaMapa(Vehiculo vehiculo) throws Exception {
    return new VistaMapa(this.mapa);
  }

  public void iniciarJuego(Vehiculo vehiculo) {
    this.vehiculoEnJuego = vehiculo;
    this.mapa = this.builder.crearGameplay();
  }


  public boolean jugar(char input) {
    int puntaje = this.vehiculoEnJuego.movimientos();
    try{
      this.mapa.avanzar(vehiculoEnJuego, input);
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