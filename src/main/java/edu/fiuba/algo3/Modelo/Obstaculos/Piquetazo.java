package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.HayPiqueteException;
import edu.fiuba.algo3.Modelo.Vehiculo.*;

public class Piquetazo implements Obstaculo {
  private static final String NOMBRE = "piquetazo";

  @Override
  public String nombreObstaculo() {
    return NOMBRE;
  }

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + ";" + NOMBRE;
  }

  @Override
  public int visit(Moto moto) {
    throw new HayPiqueteException();
  }

  @Override
  public int visit(Auto4x4 auto4x4) {
    throw new HayPiquetazoException();
  }

  @Override
  public int visit(Auto auto) {
    throw new HayPiqueteException();
  }
}
