package edu.fiuba.algo3.modelo;

public abstract class Obstaculo {
  protected int posicion;

  public boolean tieneMismaPosicion(int posicion) {
    return posicion == this.posicion;
  }

  public abstract void penalizar(Auto auto);

  public abstract void penalizar(Moto moto);

  public abstract void penalizar(Auto4x4 auto4x4);
}
