package edu.fiuba.algo3.modelo;

public class Piquete implements IVisitor {
  public int visit(Auto auto) {
    throw new HayPiqueteException();
  }

  public int visit(Moto moto) {
    return 2;
  }

  public int visit(Auto4x4 auto4x4) {
    throw new HayPiqueteException();
  }
}
