package edu.fiuba.algo3.modelo;

import java.util.Random;

public class ControlPolicial implements IVisitor{
    private static ControlPolicial instance;
    private static final int probabilidadMoto = 8;
    private static final int probabilidadAuto = 5;
    private static final int probabilidadAuto4x4 = 3;
    private static final int multa = 3;

    public static ControlPolicial getInstance()
    {
        if(instance == null)
            instance = new ControlPolicial();
        return instance;

    }
    @Override
    public int visit(Moto moto) {
        return multar(probabilidadMoto);
    }

    @Override
    public int visit(Auto4x4 auto4x4) {
        return multar(probabilidadAuto4x4);
    }

    @Override
    public int visit(Auto auto) {
        return multar(probabilidadAuto);
    }

    public int multar(int probabilidad)
    {
        Random rand = new Random();
        int parado = rand.nextInt(10); // va entre 0 y 9
        if(parado < probabilidad)
            return multa;
        return 0;
    }
}
