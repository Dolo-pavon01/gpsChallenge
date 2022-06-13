package edu.fiuba.algo3.modelo;

public class Pozo implements Penalizador {

  private int contadorPozos;
  private static final int LIMITE_POZOS_ATRAVESADOS = 2;

  public Pozo() {
    this.contadorPozos = 0;
  }

  public int visit(Moto moto) {
    return 3;
  }

  public int visit(Auto4x4 auto4x4) {
    this.contadorPozos += 1;
    if (contadorPozos > LIMITE_POZOS_ATRAVESADOS) return 2;
    return 0;
  }

  public int visit(Auto auto) {
    return 3;
  }
}
