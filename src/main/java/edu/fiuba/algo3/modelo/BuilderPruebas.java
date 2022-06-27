package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class BuilderPruebas {
  private int tamanio;

  public BuilderPruebas(int tamanio) {
    this.tamanio = tamanio;
  }

  public Mapa crearGameplay() {

    Random randomizador = new Random();
    Creador creadorObstaculos = new CreadorObstaculos();
    Creador creadorParedes = new CreadorParedes();
    Creador creadorSorpresas = new CreadorSorpresas();
    HashMap<Posicion,IVisitor> obstaculos = creadorObstaculos.crear(tamanio);
    HashMap<Posicion,Sorpresa> sorpresas = creadorSorpresas.crear(tamanio);
    HashMap<Posicion,Pared> paredes = creadorParedes.crear(tamanio);
    int xDeMeta = 19;//randomizador.nextInt(tamanio);
    int yDeMeta = 1; //randomizador.nextInt(tamanio);
    Posicion meta = Posicion.getPosicion(xDeMeta,yDeMeta);
    return new Mapa(paredes, obstaculos, sorpresas, meta);
  }
}
