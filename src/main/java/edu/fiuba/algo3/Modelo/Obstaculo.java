package edu.fiuba.algo3.Modelo;

public interface Obstaculo {

  String nombreObstaculo();
  int visit(Moto moto);

  int visit(Auto4x4 auto4x4);

  int visit(Auto auto);
}
