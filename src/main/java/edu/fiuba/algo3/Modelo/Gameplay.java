package edu.fiuba.algo3.Modelo;

import java.util.HashMap;
import java.util.Random;

public class Gameplay {
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private boolean llegoAMeta;
  private String nickname;
  private MapaBuilder builder;

  public Gameplay() {

  }
  public Gameplay(MapaBuilder builder)
  {
    this.builder = builder;
    this.mapa = this.builder.crearMapa();
  }

  public Mapa getMapa()
  {
    return this.mapa;
  }
/*
  public HashMap getObstaculos()
  {
    //clave :"0;1" valor: "ControlPolicial"
  }
  public HashMap getSorpresas()
  {

  }

  /*
  public String getVehiculo()
  {
    // ejemplo: "0;1;Moto"
  }
   */


  public int getDimension(){
    return this.mapa.getDimension();

  }
  public Mapa iniciarJuego(Vehiculo vehiculo) {
    this.vehiculoEnJuego = vehiculo;
    this.mapa = this.builder.getMapa();
    return this.mapa;
  }
  public void registrarUsuario(String usuario, String vehiculoElegido){
     this.nickname = usuario;
     if(vehiculoElegido == "Auto"){
       this.vehiculoEnJuego = new Vehiculo( new Auto());
     }
    if(vehiculoElegido == "Moto"){
      this.vehiculoEnJuego = new Vehiculo(new Moto());
    }
    if(vehiculoElegido == "Auto4x4"){
      this.vehiculoEnJuego = new Vehiculo(new Auto4x4());
    }
  }
  public boolean jugar(char input)
  {
    int puntaje = this.vehiculoEnJuego.movimientos();
    this.mapa.avanzar(this.vehiculoEnJuego, input);
    return(this.vehiculoEnJuego.movimientos() != puntaje);
  }

  public String posicionJugador()
  {
    return(this.vehiculoEnJuego.getPosicion().posicionAString());
  }

  public boolean llegoAMeta()
  {
    return this.mapa.llegoAMeta();
  }

  public int puntaje()
  {
    return this.vehiculoEnJuego.movimientos();
  }
}
