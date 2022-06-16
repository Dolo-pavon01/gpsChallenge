package edu.fiuba.algo3.modelo;

import java.util.Random;

public class ControlPolicial implements IVisitor {
  private static final int probabilidadMoto = 8;
  private static final int probabilidadAuto = 5;
  private static final int probabilidadAuto4x4 = 3;
  private static final int limite = 10;
  private static final int multa = 3;

  public int multar(int probabilidad) {
    Random rand = new Random();
    int parado = rand.nextInt(limite); // va entre 0 y 9
    if (parado < probabilidad) return multa;
    return 0;
  }

  @Override
  public int visit(Moto moto) {
    return this.multar(probabilidadMoto);
  }

  @Override
  public int visit(Auto4x4 auto4x4) {
    return this.multar(probabilidadAuto4x4);
  }

  @Override
  public int visit(Auto auto) {
    return this.multar(probabilidadAuto);
  }
}
