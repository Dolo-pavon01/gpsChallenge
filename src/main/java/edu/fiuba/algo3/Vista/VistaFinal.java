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
import java.util.ArrayList;

public class VistaFinal  {
    /*
       Encargada de mostrar la vista final con:
            -Ranking
            -Nombre de Usuario Actual, sus movimientos generados y
            su posicion en el ranking
       Utiliza el controlador de vista final.
     */

    public ArrayList<String> informacion = new ArrayList<String>();
    private Stage stage;
    private ControladorVistaFinal controladorFinal = new ControladorVistaFinal();
    private ArrayList items = new ArrayList();
    private Pane group = new Pane();
    private ArrayList elements = new ArrayList<>();



    public VistaFinal(Stage stage){

        this.stage = stage;

    }
    public void mostrarVistaFinal(){

        /*
        Cuando llega a la meta se puede poner una opcion que diga
        "Click Aqui para ver los datos del juego"
        ButtonShowStatus.setOnAction(new ControladorVistaFinal(this.informacion));

        codigo para mostrar informacion

         */

        ArrayList<String> infoRankings = this.controladorFinal.getRankings();


        for(int i =0;i< infoRankings.size();i++){
            Text informacion = new Text(infoRankings.get(i));
            String[] split = informacion.getText().split(";");
            Text nombre  = new Text(split[0]);
            System.out.println("Nombre:"+ split[0] + "Puntaje:" + split[1]);
            Text puntaje = new Text(split[1]);
            nombre.setX(320);
            nombre.setY(175+(i*35));
            puntaje.setX(750);
            puntaje.setY(175+(i*35));
            this.elements.add(nombre);
            this.elements.add(puntaje);
            System.out.println(infoRankings.get(i));
        }


        Scene scene = new Scene(this.group,1200,600);
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
