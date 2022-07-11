package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Vehiculo.*;

import java.util.ArrayList;
import java.util.List;

public class Gameplay {
  private static final String MOTO = "Moto";
  private static final String AUTO = "Auto";
  private static final String AUTO4x4 = "Auto4x4";
  private static Gameplay instancia;
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private final int POSICION_INICIAL_X = 0;
  private MapaBuilder builder;
  private String nombreUsuario;
  private Partida partida;

  public static Gameplay getInstance(MapaBuilder mapaBuilder) {
    if (instancia == null) {
      instancia = new Gameplay();
    }
    instancia.setBuilder(mapaBuilder);
    return instancia;
  }

  public static Gameplay getInstance() {
    if (instancia == null) {
      instancia = new Gameplay();
    }
    return instancia;
  }

  private Gameplay() {
    this.builder = new MapaBuilder();
    this.mapa = this.builder.crearGameplay();
    this.partida = new Partida();
  }

  private void setBuilder(MapaBuilder mapaBuilder) {
    this.builder = mapaBuilder;
    this.mapa = this.builder.getMapa();
  }

  public Mapa getMapa() {
    return this.mapa;
  }

  public ArrayList<String> getObstaculos() {
    return this.mapa.getObstaculos();
  }

  public ArrayList<String> getSorpresas() {
    return this.mapa.getSorpresas();
  }

  public String getVehiculo() {
    return this.vehiculoEnJuego.datosVehiculo();
  }

  public Mapa iniciarJuego(Vehiculo vehiculo) {
    this.vehiculoEnJuego = vehiculo;
    return this.mapa;
  }

  private void crearVehiculoEnJuego(TipoVehiculo tipoVehiculo) {
    this.vehiculoEnJuego =
        new Vehiculo(
            tipoVehiculo, Posicion.getPosicion(POSICION_INICIAL_X, this.mapa.getAlto() / 2));
  }

  public void registrarUsuario(String usuario, String vehiculoElegido) {
    this.nombreUsuario = usuario;
    if (vehiculoElegido == AUTO) {
      this.crearVehiculoEnJuego(new Auto());
    }
    if (vehiculoElegido == MOTO) {
      this.crearVehiculoEnJuego(new Moto());
    }
    if (vehiculoElegido == AUTO4x4) {
      this.crearVehiculoEnJuego(new Auto4x4());
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

  public String getMeta() {
    return this.mapa.getMeta();
  }

  public int getAlto() {
    return this.mapa.getAlto();
  }

  public ArrayList<String> infoRankings() {
    return this.partida.actualizarPodio(this.nombreUsuario, this.puntaje());
  }
}
