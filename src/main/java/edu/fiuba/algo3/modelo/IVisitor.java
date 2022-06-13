package edu.fiuba.algo3.modelo;

public interface IVisitor {

  int visit(Moto moto);

  int visit(Auto4x4 auto4x4);

  int visit(Auto auto);
}