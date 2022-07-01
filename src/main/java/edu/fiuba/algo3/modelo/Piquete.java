package edu.fiuba.algo3.modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Piquete implements IVisitor {
  private static final int MULTA_MOTO = 2;

  public String dibujar()  {
    return "docs/piquete.png";
  }

  public int visit(Moto moto) {
    return MULTA_MOTO;
  }

  public int visit(Auto auto) {
    throw new HayPiqueteException();
  }

  public int visit(Auto4x4 auto4x4) {
    throw new HayPiqueteException();
  }
}
