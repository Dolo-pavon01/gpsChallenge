package edu.fiuba.algo3.modelo;

public class Piquete implements IVisitor {
  private static Piquete instance;
  private static final int multaMoto =2;
  public static Piquete getInstance()
  {
    if(instance == null)
      instance = new Piquete();
    return instance;

  }
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
