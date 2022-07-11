package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorVistaFinal;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class VistaFinal  {


    private Stage stage;
    private ControladorVistaFinal controladorFinal = new ControladorVistaFinal();
    private ArrayList items = new ArrayList();
    private Pane group = new Pane();
    private ArrayList elements = new ArrayList<>();



    public VistaFinal(Stage stage){

        this.stage = stage;

    }
    public String fileToString(File stylesheetFile) {
        try {
            return stylesheetFile.toURI().toURL().toString();
        } catch (MalformedURLException e) {
            return null;
        }
    }


    public void mostrarVistaFinal(){


        ArrayList<String> infoRankings = this.controladorFinal.getRankings();
        String stylesheet = fileToString(new File("src/main/java/edu/fiuba/algo3/Vista/estilos.css"));

        for(int i =0;i< infoRankings.size();i++){
            Text informacion = new Text(infoRankings.get(i));
            String[] split = informacion.getText().split(";");
            Text nombre  = new Text(split[0]);
            Text puntaje = new Text(split[1]);

            nombre.setX(330);
            nombre.setY(175+(i*50));
            nombre.getStyleClass().add("nombreRanking");

            puntaje.setX(780);
            puntaje.setY(175+(i*50));
            puntaje.getStyleClass().add("puntajeRanking");

            this.elements.add(nombre);
            this.elements.add(puntaje);

        }


        Scene scene = new Scene(this.group,1200,600);
        scene.getStylesheets().add(stylesheet);
        Image img = new Image(new File("docs/ranking.png").toURI().toString());
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        this.group.setBackground(bGround);
        this.group.getChildren().addAll(this.elements);
        this.stage.setScene(scene);
        this.stage.setMaximized(true);
        this.stage.show();



    }

}
