package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Vehiculo.Mapa;
import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto4x4;
import edu.fiuba.algo3.Modelo.Vehiculo.Moto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gameplay {
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private String nickname;
  private MapaBuilder builder;

  public Gameplay() {}

  public Gameplay(MapaBuilder builder) {
    this.builder = builder;
    this.mapa = builder.getMapa();
  }

  public Mapa getMapa() {
    return this.mapa;
  }

  public List getObstaculos() {

    /*
    HashMap obstaculosComoString = new HashMap(10, 70);
    for (int i = 0; i < this.mapa.getAlto(); i++) {
      for (int j = 0; j < this.mapa.getAncho(); j++) {
        Posicion p = Posicion.getPosicion(i, j);
        String nombreObstaculo = this.mapa.obstaculoEnPosicion(p).nombreObstaculo();
        String posicion = p.posicionAString();
        obstaculosComoString.put(posicion, nombreObstaculo);
      }
    }
    return obstaculosComoString;
     */
    // return new ArrayList(Arrays.asList("3;1;pozo"));
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
      this.vehiculoEnJuego = new Vehiculo(new Auto());
    }
    if (vehiculoElegido == "Moto") {
      this.vehiculoEnJuego = new Vehiculo(new Moto());
    }
    if (vehiculoElegido == "Auto4x4") {
      this.vehiculoEnJuego = new Vehiculo(new Auto4x4());
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
