package edu.fiuba.algo3.Modelo;

import java.util.HashMap;
import java.util.Random;

public class Gameplay {
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private boolean llegoAMeta;
  private String nickname;

  public Gameplay() {

    this.llegoAMeta = false;
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
   // this.mapa.generarMapa(this.vehiculoEnJuego);
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
  public boolean jugar(char input) {
    int puntaje = this.vehiculoEnJuego.movimientos();
    try{
      this.mapa.avanzar(this.vehiculoEnJuego, input);
    }
    catch (LlegoAMetaException e)
    {
      this.llegoAMeta = true;
    }
    //cambiar por booleano la excepcion
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

  public int puntaje()
  {
    return this.vehiculoEnJuego.movimientos();
  }
}
