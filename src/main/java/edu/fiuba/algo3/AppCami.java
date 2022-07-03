package edu.fiuba.algo3;

import edu.fiuba.algo3.controllers.HandlerBotonVehiculo;
import edu.fiuba.algo3.controllers.HandlerMoverVehiculo;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.visuales.Etiqueta;
import edu.fiuba.algo3.visuales.VistaMapa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.stage.Stage;


public class AppCami extends Application {
    private Vehiculo vehiculo;
    private ImageView dibujoVehiculo;

    public void start(Stage primaryStage) throws Exception {

        this.vehiculo = new Vehiculo();

        TextField nombreInput = new TextField("Ingresar nombre del jugador");
        Label etiquetaVehiculos = new Label("Elija su vehículo");
        Button motoBtn = new Button("Moto");
        Button autoBtn = new Button("Auto");
        Button auto4x4Btn = new Button("Auto 4x4");
        Button comenzar = new Button("COMIENZA A JUGAR!!");
        HBox contenedorVehiculos = new HBox(motoBtn, autoBtn, auto4x4Btn);
        contenedorVehiculos.setSpacing(10);
        Label espacioVacio = new Label();

        VBox contenedorPrincipal = new VBox(nombreInput, etiquetaVehiculos, contenedorVehiculos, espacioVacio,comenzar);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

        Scene inicio = new Scene(contenedorPrincipal, 300, 250);
        primaryStage.setTitle("Inicio GPS Challenge");
        primaryStage.setScene(inicio);
        primaryStage.show();

        this.dibujoVehiculo = new ImageView();
        this.dibujoVehiculo.setY(300);
        this.dibujoVehiculo.setPreserveRatio(true);
        this.dibujoVehiculo.setFitHeight(50);

        autoBtn.setOnAction(new HandlerBotonVehiculo(this.vehiculo,this.dibujoVehiculo,new Auto(),"Auto"));
        motoBtn.setOnAction(new HandlerBotonVehiculo(this.vehiculo,this.dibujoVehiculo,new Moto(),"Moto"));
        auto4x4Btn.setOnAction(new HandlerBotonVehiculo(this.vehiculo,this.dibujoVehiculo,new Auto4x4(),"Auto4x4"));


        Label nombreJugador = new Label();
        nombreJugador.setLayoutX(200);
        nombreJugador.setLayoutY(300);
        new Etiqueta().aplicarDefault(nombreJugador);


        Label displayPuntaje = new Etiqueta().crearEtiqueta("Puntaje : 0",200,300);

        Label displayPosicion = new Etiqueta().crearEtiqueta("Posicion Actual: 0,1",200,400);

        VistaMapa vistaMapa = new VistaMapa();
        Gameplay gameplay = new Gameplay(new MapaFactory((int) vistaMapa.callesEnY, (int) vistaMapa.callesEnX));
        gameplay.iniciarJuego(vehiculo);
        Group group = new Group(vistaMapa.crearMapa(gameplay.getMapa()),nombreJugador,displayPuntaje,displayPosicion,this.dibujoVehiculo);
        Scene juego = new Scene(group,500,500, Color.BLACK);

        Label finDeJuego = new Label();
        finDeJuego.setTextFill(Color.WHITESMOKE);
        Group fin = new Group(finDeJuego);
        Scene pantallaFinal = new Scene(fin,500,500, Color.BLACK);
        comenzar.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent arg0) {
                nombreJugador.setText("Jugador: " + nombreInput.getText());
                primaryStage.setScene(juego);
            }
        });

        juego.setOnKeyPressed(KeyEvent->
        {
            new HandlerMoverVehiculo(gameplay,dibujoVehiculo, KeyEvent.getCode(),vistaMapa.largoMovimiento);
            displayPuntaje.setText("Puntaje: " + gameplay.puntaje());
            displayPosicion.setText("Posicion Actual: " + gameplay.posicionJugador());
            if(gameplay.llegoAMeta())
            {
                finDeJuego.setText("TERMINASTE EL JUEGO " + nombreJugador.getText() + " CON UN PUNTAJE DE  " + displayPuntaje.getText());
                primaryStage.setScene(pantallaFinal);
            }
        });
    }
    public static void main (String[] args)
    {
        launch(args);
    }
}
