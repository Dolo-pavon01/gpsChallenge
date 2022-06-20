package edu.fiuba.algo3.modelo;

public class Pozo implements IVisitor {
  private static final int LIMITE_POZOS_ATRAVESADOS = 2;
  private static final int MULTA_AUTO = 3;
  private static final int MULTA_MOTO = 3;
  private static final int MULTA_AUTO4x4 = 2;

  public int visit(Moto moto) {
    return MULTA_MOTO;
  }

  // TODO: Acá se está rompiendo el encapsulamiento en auto4x4
  public int visit(Auto4x4 auto4x4) {
    auto4x4.aumentarContadorPozos();
    if (auto4x4.esMultadoPorPozo(LIMITE_POZOS_ATRAVESADOS))
    {
      auto4x4.resetearContadorPozo();
      return MULTA_AUTO4x4;
    }
    return 0;
  }

  public int visit(Auto auto) {
    return MULTA_AUTO;
  }
}
