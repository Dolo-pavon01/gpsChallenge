package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Vehiculo.Auto;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto4x4;
import edu.fiuba.algo3.Modelo.Vehiculo.Moto;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;

public class ObstaculoNulo implements Obstaculo {
  private final String NOMBRE = "obstaculoNulo";
  private final String SEPARADOR = ";";

  @Override
  public String nombreObstaculo() {
    return NOMBRE;
  }

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + SEPARADOR + NOMBRE;
  }

  @Override
  public int visit(Moto moto) {
    return 0;
  }

  @Override
  public int visit(Auto4x4 auto4x4) {
    return 0;
  }

  @Override
  public int visit(Auto auto) {
    return 0;
  }
}
