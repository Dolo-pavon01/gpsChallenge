package edu.fiuba.algo3.modelo;

public class ObstaculoNulo implements IVisitor {
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
