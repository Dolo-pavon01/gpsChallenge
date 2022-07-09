package edu.fiuba.algo3.Modelo;


import java.util.HashMap;

public class Gameplay {
  private Vehiculo vehiculoEnJuego;
  private Mapa mapa;
  private String nickname;
  private MapaBuilder builder;

  public Gameplay() {

  }
  public Gameplay(MapaBuilder builder)
  {
    this.builder = builder;
    this.mapa = builder.getMapa();
  }

  public Mapa getMapa()
  {
    return this.mapa;
  }

  public HashMap getObstaculos()
  {

    HashMap obstaculosComoString = new HashMap(10,70);
    for(int i = 0; i < this.mapa.getAlto(); i++)
    {
      for(int j = 0; j< this.mapa.getAncho();j++)
      {
        Posicion p = Posicion.getPosicion(i,j);
        String nombreObstaculo = this.mapa.obstaculoEnPosicion(p).nombreObstaculo();
        String posicion = p.posicionAString();
        obstaculosComoString.put(posicion,nombreObstaculo);
      }

    }
    return obstaculosComoString;
  }
  public HashMap getSorpresas() {

    HashMap sorpresaComoString = new HashMap(10,70);
    for(int i = 0; i < this.mapa.getAlto(); i++)
    {
      for(int j = 0; j< this.mapa.getAncho();j++)
      {
        Posicion p = Posicion.getPosicion(i,j);
        String nombreObstaculo = this.mapa.sorpresaEnPosicion(p).nombreSorpresa();
        String posicion = p.posicionAString();
        sorpresaComoString.put(posicion,nombreObstaculo);
      }

    }
    return sorpresaComoString;

  }
  public String getVehiculo()
  {
    return vehiculoEnJuego.datosVehiculo();

  }

  public int getDimension(){
    return this.mapa.getDimension();

  }
  public Mapa iniciarJuego(Vehiculo vehiculo) {
    this.vehiculoEnJuego = vehiculo;
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
    return this.vehiculoEnJuego.posicionComoString();
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
