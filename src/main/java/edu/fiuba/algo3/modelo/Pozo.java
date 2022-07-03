package edu.fiuba.algo3.modelo;

public class Pozo implements Obstaculo {
  private static final int MULTA_AUTO = 3;
  private static final int MULTA_MOTO = 3;
  private static final int MULTA_AUTO4x4 = 2;
  private static final int LIMITE_POZOS = 2;
  private static final int MULTA_CERO = 0;

  @Override
    public String nombreObstaculo()  {
      return "pozo";
    }


  public int visit(Moto moto) {
    return MULTA_MOTO;
  }

  public int visit(Auto4x4 auto4x4) {
    auto4x4.recibirImpacto();
    if (auto4x4.esPenalizado(LIMITE_POZOS)) {
      auto4x4.reiniciarImpactosRecibidos();
      return MULTA_AUTO4x4;
    }
    return MULTA_CERO;
  }

  public int visit(Auto auto) {
    return MULTA_AUTO;
  }
}
