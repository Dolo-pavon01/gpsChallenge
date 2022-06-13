package edu.fiuba.algo3.modelo;

public class Pozo implements IVisitor {
  private  static Pozo instance;
  private int contadorPozos;
  private static final int LIMITE_POZOS_ATRAVESADOS = 2;
  private static final int multaAuto =3;
  private static final int multaMoto = 3;
  private static final int multaAuto4x4 = 2;
  private Pozo()
  {
    this.contadorPozos =0;
  }

  public void resetContadorPozos() {
    this.contadorPozos = 0;
  }

  public static Pozo getInstance()
  {
    if(instance == null)
      instance = new Pozo();
    return instance;
  }


  public int visit(Moto moto) {
    this.contadorPozos = 0;
    return multaMoto;
  }

  public int visit(Auto4x4 auto4x4) {
    this.contadorPozos += 1;
    if (this.contadorPozos > LIMITE_POZOS_ATRAVESADOS)
    {
      this.contadorPozos = 0;
      return multaAuto4x4;
    }
    return 0;
  }

  public int visit(Auto auto) {
    this.contadorPozos = 0;
    return multaAuto;
  }
}
