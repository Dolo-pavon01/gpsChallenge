package edu.fiuba.algo3.modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pozo implements IVisitor {
  private static final int MULTA_AUTO = 3;
  private static final int MULTA_MOTO = 3;
  private static final int MULTA_AUTO4x4 = 2;
  private static final int LIMITE_POZOS = 2;
  private static final int MULTA_CERO = 0;

  @Override
    public String dibujar()  {
      return "docs/pozo.png";
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
