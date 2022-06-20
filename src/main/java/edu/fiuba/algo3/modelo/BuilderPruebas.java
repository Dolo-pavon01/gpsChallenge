package edu.fiuba.algo3.modelo;

public class BuilderPruebas {
  private int tamanio;

  public BuilderPruebas(int tamanio) {
    this.tamanio = tamanio;
  }

  public Mapa crearGameplay() {
    Mapa mapa = new Mapa();
    for (int i = 1; i < tamanio / 3; i++) {
      Posicion p = Posicion.getPosicion(i, 0);
      mapa.obstaculos.put(p, new Pozo());
    }
    for (int i = 1; i < tamanio / 3; i++) {
      Posicion p = Posicion.getPosicion(0, i);
      mapa.obstaculos.put(p, new Piquete());
    }
    for (int i = 2; i < tamanio / 3; i++) {
      Posicion p = Posicion.getPosicion(i, i);
      mapa.obstaculos.put(p, new ControlPolicial());
    }

    for (int i = 2; i < tamanio / 5; i++) {
      Posicion p = Posicion.getPosicion(i, i + 1);
      mapa.sorpresas.put(p, new SorpresaCambioVehiculo());
    }
    for (int i = 3; i < tamanio / 5; i++) {
      Posicion p = Posicion.getPosicion(i, i - 1);
      mapa.sorpresas.put(p, new SorpresaFavorable());
    }
    for (int i = 4; i < tamanio / 5; i++) {
      Posicion p = Posicion.getPosicion(i, i + 2);
      mapa.sorpresas.put(p, new SorpresaDesfavorable());
    }
    return mapa;
  }
}
