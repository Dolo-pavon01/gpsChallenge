package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorVistaFinal;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private Group group = new Group();
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
            Text nombre = new Text(200,200*(20+i),infoRankings.get(i));
            this.elements.add(nombre);
        }
        this.group.getChildren().addAll(this.elements);
        Scene scene = new Scene(this.group,1000,600);
        scene =this.stage.getScene();

        this.stage.setScene(scene);
        this.stage.show();

    }

}
