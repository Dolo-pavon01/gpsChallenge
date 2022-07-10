package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorOpciones;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.net.MalformedURLException;

public class VistaInicial  {
    /*
        implementa la vista inicial del juego,
        se gestionan las acciones mediante su controlador
    */
    private String nickname;
    private String vehiculoElegido;
    private TextField nombreInput = new TextField();
    private Button autoBtn = new Button();
    private Button  motoBtn = new Button();
    private Button auto4x4Btn = new Button();
    private Button btnJugar = new Button();
    private Stage stage;
    public String fileToString(File stylesheetFile) {
        try {
            return stylesheetFile.toURI().toURL().toString();
        } catch (MalformedURLException e) {
            return null;
        }
    }
    public VistaInicial(Stage stage){
        this.stage = stage;
    }
    public void mostrarVistaInicial() throws Exception  {
        /*
            inicializa la vista principal, se muestra al usuario las
            opciones disponibles, se guarda el nombre del usuario

            IMPORTANTE:
                Como se cuando el usuario lleno el campo del nombre???
                habria alguna forma de validar a la hora de apretar el boton de jugar
                y impedir que el usaurio continue y mostrar un mensaje si el campo nombre está vacio?
         */

        String stylesheet = fileToString(new File("src/main/java/edu/fiuba/algo3/Vista/estilos.css"));

        Text titulo = new Text("¡Bienvenido a GPS Challenge!");
        titulo.setId("titulo");

        Text elija = new Text("Elija su vehículo");
        elija.setId("elija");

        this.btnJugar.setText("JUGAR");
        this.btnJugar.setId("btnJugar");

        this.nombreInput.setPromptText("NOMBRE DEL JUGADOR");
        this.nombreInput.setId("nombreInput");

        this.motoBtn.setText("Moto");
        this.motoBtn.getStyleClass().add("botones");

        this.autoBtn.setText("Auto");
        this.autoBtn.getStyleClass().add("botones");

        this.auto4x4Btn.setText("Auto 4x4");
        this.auto4x4Btn.getStyleClass().add("botones");

        HBox divBotones = new HBox(motoBtn, autoBtn, auto4x4Btn);
        divBotones.setId("divBotones");

        VBox divContenedor = new VBox(this.nombreInput, divBotones);
        divContenedor.setId("divContenedor");

        Group grupo = new Group(titulo, elija, btnJugar, divContenedor);

        Scene escena = new Scene(grupo, 700, 500);
        escena.getStylesheets().add(stylesheet);

        this.stage.setTitle("Menú Inicial");
        this.stage.setScene(escena);
        this.stage.show();

        this.autoBtn.setOnAction(evento->{
            this.vehiculoElegido = "Auto";
        });

        this.motoBtn.setOnAction(evento->{
            this.vehiculoElegido = "Moto";
        });

        this.auto4x4Btn.setOnAction(evento->{
            this.vehiculoElegido = "Auto4x4";
        });

        this.btnJugar.setOnAction(evento->{
            this.nickname = this.nombreInput.getText();
            new ControladorOpciones(this.nickname,this.vehiculoElegido);
            System.out.println("hola");
            try {
                new VistaMapa(this.stage).mostrarVistaMapa(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
