package edu.fiuba.algo3.modelo;

import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public interface IVisitor {

  String dibujar();
  int visit(Moto moto);

  int visit(Auto4x4 auto4x4);

  int visit(Auto auto);
}
