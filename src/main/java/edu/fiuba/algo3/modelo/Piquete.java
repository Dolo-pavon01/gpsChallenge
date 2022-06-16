package edu.fiuba.algo3.modelo;

public class Piquete implements IVisitor {
  private static final int multaMoto =2;

  public int visit(Auto auto) {
    throw new HayPiqueteException();
  }

  public int visit(Moto moto) {
    return multaMoto;
  }

  public int visit(Auto4x4 auto4x4) {
    throw new HayPiqueteException();
  }
}
