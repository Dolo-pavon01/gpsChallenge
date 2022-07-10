package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Vehiculo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gameplay {
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private final int POSICION_INICIAL_X = 0;
  private String nickname;
  private MapaBuilder builder;

  public Gameplay(MapaBuilder builder) {
    this.builder = builder;
    this.mapa = builder.getMapa();
  }

  public Mapa getMapa() {
    return this.mapa;
  }

  public List getObstaculos() {
    return this.mapa.getObstaculos();
  }

  public List getSorpresas() {
    return this.mapa.getSorpresas();
  }

  public String getVehiculo() {
    return vehiculoEnJuego.datosVehiculo();
  }

  public Mapa iniciarJuego(Vehiculo vehiculo) {
    this.vehiculoEnJuego = vehiculo;
    return this.mapa;
  }

  public void registrarUsuario(String usuario, String vehiculoElegido) {
    this.nickname = usuario;
    if (vehiculoElegido == "Auto") {
      this.vehiculoEnJuego =
          new Vehiculo(
              new Auto(), Posicion.getPosicion(POSICION_INICIAL_X, this.mapa.getAlto() / 2));
    }
    if (vehiculoElegido == "Moto") {
      this.vehiculoEnJuego =
          new Vehiculo(
              new Moto(), Posicion.getPosicion(POSICION_INICIAL_X, this.mapa.getAlto() / 2));
    }
    if (vehiculoElegido == "Auto4x4") {
      this.vehiculoEnJuego =
          new Vehiculo(
              new Auto4x4(), Posicion.getPosicion(POSICION_INICIAL_X, this.mapa.getAlto() / 2));
    }
  }

  public boolean jugar(char input) {
    int movimientosAnteriores = this.vehiculoEnJuego.movimientos();
    this.mapa.avanzar(this.vehiculoEnJuego, input);
    return (this.vehiculoEnJuego.movimientos() != movimientosAnteriores);
  }

  public String posicionJugador() {
    return this.vehiculoEnJuego.posicionComoString();
  }

  public boolean llegoAMeta() {
    return this.mapa.llegoAMeta();
  }

  public int puntaje() {
    return this.vehiculoEnJuego.movimientos();
  }

  /*public void infoRankings(ArrayList<String> rankingsJugadores){

      this.Partida.actualizarPodio(this.nickname,this.puntaje());
      }

  }*/
}
