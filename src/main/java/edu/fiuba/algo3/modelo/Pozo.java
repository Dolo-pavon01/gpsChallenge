package edu.fiuba.algo3.modelo;

public class Pozo implements IVisitor {
  private static final int LIMITE_POZOS_ATRAVESADOS = 2;
  private static final int multaAuto =3;
  private static final int multaMoto = 3;
  private static final int multaAuto4x4 = 2;


  public int visit(Moto moto) {
    return multaMoto;
  }


  public int visit(Auto4x4 auto4x4) {
    auto4x4.contadorPozos += 1;
    if (auto4x4.contadorPozos > LIMITE_POZOS_ATRAVESADOS)
    {
      auto4x4.contadorPozos = 0;
      return multaAuto4x4;
    }
    return 0;
  }

  public int visit(Auto auto) {
    return multaAuto;
  }
}
