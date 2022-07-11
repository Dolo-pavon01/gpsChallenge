package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.HayPiqueteException;
import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto4x4;
import edu.fiuba.algo3.Modelo.Vehiculo.Moto;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;

public class Piquete implements Obstaculo {
  private static final int MULTA_MOTO = 2;
  private final String NOMBRE = "piquete";
  private final String SEPARADOR = ";";

  public String nombreObstaculo() {
    return NOMBRE;
  }

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + SEPARADOR + NOMBRE;
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
