package edu.fiuba.algo3.modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ObstaculoNulo implements IVisitor {


    @Override
    public String dibujar()  {
        return null;
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
