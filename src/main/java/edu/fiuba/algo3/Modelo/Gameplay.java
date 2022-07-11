package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Vehiculo.*;

import java.util.ArrayList;
import java.util.List;

public class Gameplay {
  protected static final String MOTO = "Moto";
  protected static final String AUTO = "Auto";
  protected static final String AUTO4x4 = "Auto4x4";
  private static Gameplay instancia;
  protected Vehiculo vehiculoEnJuego;
  protected Mapa mapa;
  protected final int POSICION_INICIAL_X = 0;
  protected String nombreUsuario;
  private Partida partida;


  public static Gameplay getInstance() {
    if (instancia == null) {
      instancia = new Gameplay();
    }
    return instancia;
  }

  protected Gameplay() {
    this.mapa = new MapaBuilder().crearGameplay();
    this.partida = new Partida();
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
