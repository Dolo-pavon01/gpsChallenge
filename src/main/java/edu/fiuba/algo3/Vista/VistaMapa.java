package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorVistaMapa;
import edu.fiuba.algo3.Controlador.ControladorSonido;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;

import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VistaMapa {
  /*
      Implementa la vista del mapa con:
          -Obstaculos
          -Vehiculo
          -Meta
          -Manzanas
          -Calles
       utiliza el controlador de interacciones entre el usuario
       y el mapa.
  */
  private Stage stage;
  private double startMapX = 0;
  private double startMapY = 0;
  private double widthMap = Toolkit.getDefaultToolkit().getScreenSize().width;
  private double heightMap = this.widthMap / 2;
  private ImageView dibujoVehiculo = new ImageView();
  private double AnchoAltoMatriz;
  private int callesEnY;
  private double altoCalle;
  private double altoAnchoCuadra;
  private int callesEnX;
  private List elements = new ArrayList();
  private Group group = new Group();
  private Rectangle capa;
  private Circle circle;
  private Shape filtro;

  private double metaX;
  private double metaY;
  private Circle meta;
  private ControladorSonido sound;

  private ControladorVistaMapa controladorVistaMapa = new ControladorVistaMapa();

  public VistaMapa(Stage stage) throws Exception {
    this.stage = stage;
  }

  public void mostrarVistaMapa() throws Exception {
    Rectangle rect = this.rectangule(this.startMapX, this.startMapY, this.widthMap, this.heightMap);
    rect.setFill(Color.RED);
    int random = this.controladorVistaMapa.getDimension();

    int cantidadMatrices = random / 2;
    this.elements.add(rect);
    this.AnchoAltoMatriz = this.heightMap / cantidadMatrices;
    this.altoAnchoCuadra = this.AnchoAltoMatriz / 3; //
    this.altoCalle = this.altoAnchoCuadra / 2;
    this.callesEnY = random;
    this.callesEnX = this.callesEnY * 2;

    for (double i = this.startMapX; i < (this.widthMap + this.startMapX); i += AnchoAltoMatriz) {

      this.dibujarMatriz(
          i, this.startMapY, this.AnchoAltoMatriz, this.altoAnchoCuadra, this.altoCalle);
      for (double y = this.startMapY; y < (this.heightMap); y += this.AnchoAltoMatriz) {
        this.dibujarMatriz(i, y, AnchoAltoMatriz, this.altoAnchoCuadra, this.altoCalle);
      }
    }

    this.dibujarObstaculos();
    this.dibujarSorpresas();

    this.dibujarVehiculo();
    this.elements.add(this.dibujoVehiculo);

    Scene scene =
        new Scene(this.group, this.widthMap, this.heightMap + this.startMapY, Color.LIGHTPINK);

    this.dibujarMeta();
    this.dibujarCapa();
    this.group.getChildren().addAll(this.elements);
    this.stage.setScene(scene);
    scene.getWindow().centerOnScreen();
    this.stage.show();
    this.stage.setResizable(false);


    scene.setOnKeyPressed(
        KeyEvent -> {
          KeyCode code = KeyEvent.getCode();
          char direccion = (code.toString()).toLowerCase().charAt(0);

          try {
            if (this.controladorVistaMapa.accionar(direccion)) {
              try {
                this.dibujarVehiculo();
              } catch (Exception e) {
                throw new RuntimeException(e);
              }
              this.dibujarSecuencia(direccion);
            }
          }
          catch (Exception e){}
          if (this.controladorVistaMapa.partidaCerrada()) {
            this.sound = new ControladorSonido();
            sound.playFinish("docs/sonidoMeta.mp3");
            new VistaFinal(this.stage).mostrarVistaFinal();
          }
        });
  }

  private void dibujarCapa() {

    this.capa = this.rectangule(this.startMapX, this.startMapY, this.widthMap, this.heightMap);
    this.circle = new Circle();
    this.circle.setCenterY(this.dibujoVehiculo.getY());
    this.circle.setCenterX(this.dibujoVehiculo.getX());
    this.circle.setRadius(this.AnchoAltoMatriz);
    this.filtro = Shape.subtract(this.capa, this.circle);


    Circle  meta = new Circle();
    meta.setCenterX(this.metaX);
    meta.setCenterY(this.metaY);
    meta.setRadius(this.altoAnchoCuadra /2);
    this.meta = meta;
    this.filtro = Shape.subtract(this.filtro, meta);
    this.elements.add(filtro);
  }

  private void dibujarMeta() throws Exception {
    String posicion = this.controladorVistaMapa.meta();
    String[] coordenadas = posicion.split(";");
    int x = Integer.parseInt(coordenadas[0]);
    int y = Integer.parseInt(coordenadas[1]);


    double techo = (Math.round((this.callesEnY - y) / 2) * this.AnchoAltoMatriz) + this.startMapY;

    double startY = techo;
    if (y % 2 == 0) {
      startY += 0;
    } else {
      startY += this.altoCalle + this.altoAnchoCuadra;
    }
    this.metaX= (this.widthMap - this.altoCalle)  ;
    this.metaY= startY + 10;
    this.imagen(
        this.widthMap - this.altoCalle,
        startY,
        this.altoCalle,
        this.altoCalle,
        "docs/" + coordenadas[2] + ".png");
  }

  private void dibujarVehiculo() throws Exception {

    String posicion = this.controladorVistaMapa.vehiculo();
    String[] coordenadas = posicion.split(";");
    int x = Integer.parseInt(coordenadas[0]);
    int y = Integer.parseInt(coordenadas[1]);

    FileInputStream vehiculo = new FileInputStream("docs/" + coordenadas[2] + ".png");
    Image image_calle = new Image(vehiculo);

    this.dibujoVehiculo.setImage(image_calle);
    this.dibujoVehiculo.setX(this.posX(x));
    this.dibujoVehiculo.setY(this.posY(y));
    this.dibujoVehiculo.setFitHeight(this.altoCalle + 15);
    this.dibujoVehiculo.setFitWidth(this.altoCalle + 15 );

  }

  private double posY(int y) {

    int coordenadaY = y;
    int cantidadCallesY = this.callesEnY;
    double techo =
            (Math.round((cantidadCallesY - coordenadaY) / 2) * this.AnchoAltoMatriz) + this.startMapY;

    double startY = techo;
    if (coordenadaY % 2 == 0) {
      startY += 0;
    } else {
      startY += this.altoCalle + this.altoAnchoCuadra;
    }
    return  startY;
  }
  private double posX(int x){
    int coordenadaX = x;
    int cantidadCallesX = this.callesEnX;
    double costado = (Math.round((cantidadCallesX - (cantidadCallesX - coordenadaX)) / 2) * this.AnchoAltoMatriz);
    double startX = costado + this.startMapX;

    if (coordenadaX % 2 == 0 & coordenadaX > 0) {
      startX += 0;
    } else if (coordenadaX > 0) {
      startX += this.altoCalle + this.altoAnchoCuadra;
    }

    return  startX;
  }

  private void dibujarMatriz(double startX, double startY, double m, double t, double p)
      throws Exception {

    Rectangle calle1 = this.rectangule(startX, startY, m, p);
    calle1.setFill(Color.WHITE);

    Rectangle calle2 = this.rectangule(startX, startY + p, p, m - (p));
    calle2.setFill(Color.WHITE);

    Rectangle Manzana1 = this.rectangule(startX + p, startY + p, t, t);
    Manzana1.setFill(Color.LIGHTBLUE);

    Rectangle calle3 = this.rectangule(startX + p + t, startY + p, p, t);
    calle3.setFill(Color.WHITE);

    Rectangle Manzana2 = this.rectangule(startX + p + t + p, startY + p, t, t);
    Manzana2.setFill(Color.LIGHTBLUE);


    Rectangle calle5 = this.rectangule(startX + p, startY + p + t, m - (p), p);
    calle5.setFill(Color.WHITE);

    Rectangle Manzana3 = this.rectangule(startX + p, startY + p + t + p, t, t);
    Manzana3.setFill(Color.LIGHTBLUE);

    Rectangle calle6 = this.rectangule(startX + p + t, startY + p + t + p, p, t);
    calle6.setFill(Color.WHITE);
    Rectangle Manzana4 = this.rectangule(startX + p + t + p, startY + p + t + p, t, t);
    Manzana4.setFill(Color.LIGHTBLUE);

    this.elements.add(calle1);
    this.elements.add(calle2);
    this.elements.add(calle3);
    this.elements.add(calle5);
    this.elements.add(calle6);
    this.elements.add(Manzana1);
    this.elements.add(Manzana2);
    this.elements.add(Manzana3);
    this.elements.add(Manzana4);

    int randomImage = new Random().nextInt(13) + 1;

    this.imagen(startX + p, startY + p, t, t, "docs/ED" + randomImage + ".png");
    this.imagen(startX + p + t + p, startY + p, t, t, "docs/ED" + (randomImage + 1) + ".png");
    this.imagen(startX + p, startY + p + t + p, t, t, "docs/ED" + (randomImage + 2) + ".png");
    this.imagen(
        startX + p + t + p, startY + p + t + p, t, t, "docs/ED" + (randomImage + 3) + ".png");

    this.imagen(startX, startY, m, p, "docs/calle.png");
    this.imagen(startX, startY, p, m, "docs/calle2.png");
    this.imagen(startX + p + t, startY + p, p, t + p + t, "docs/calle2.png");
    this.imagen(startX, startY + p + t, m, p, "docs/calle.png");
  }

  private ImageView imagen(double startX, double startY, double m, double p, String path)
      throws Exception {
    FileInputStream input = new FileInputStream(path);
    Image image_calle = new Image(input);
    ImageView imageView1 = new ImageView();
    imageView1.setImage(image_calle);
    imageView1.setX(startX);
    imageView1.setY(startY);
    imageView1.setFitWidth(m);
    imageView1.setFitHeight(p);
    this.elements.add(imageView1);
    return imageView1;
  }

  private Rectangle rectangule(double x, double y, double w, double h) {
    Rectangle rect = new Rectangle();
    rect.setX(x);
    rect.setY(y);
    rect.setWidth(w);
    rect.setHeight(h);

    return rect;
  }

  private void dibujarObstaculos() throws Exception {

    ArrayList<String> obstaculos = this.controladorVistaMapa.getObstaculos();

    for (int i = 0; i < obstaculos.size(); i++) {
      String[] strings = obstaculos.get(i).split(";");
      int x = Integer.parseInt(strings[0]);
      int y = Integer.parseInt(strings[1]);
      String entidad = strings[2];
      this.imagen(this.posX(x), this.posY(y), this.altoCalle, this.altoCalle, "docs/" + entidad + ".png");
    }
  }

  private void dibujarSorpresas() throws Exception {
    ArrayList<String> sorpresas = this.controladorVistaMapa.getSorpresas();
    for (int i = 0; i < sorpresas.size(); i++) {
      String[] strings = sorpresas.get(i).split(";");
      int x = Integer.parseInt(strings[0]);
      int y = Integer.parseInt(strings[1]);
      String entidad =  strings[2];
      this.imagen(this.posX(x) + 10, this.posY(y), this.altoCalle /2 , this.altoCalle /2, "docs/" + entidad + ".png");
    }
  }

  private void dibujarSecuencia(char direccion) {

    this.dibujoVehiculo.setRotationAxis(Rotate.Z_AXIS);
    this.group.getChildren().remove(this.filtro);
    switch (direccion) {
      case 'd': // r en mac d window
        this.dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
        this.dibujoVehiculo.setX(this.dibujoVehiculo.getX());
        this.dibujoVehiculo.setRotate(0);
        break;
      case 'a': // l en mac a W
        this.dibujoVehiculo.setRotationAxis(Rotate.Y_AXIS);
        this.dibujoVehiculo.setX(this.dibujoVehiculo.getX() );
        this.dibujoVehiculo.setRotate(180);
        break;
      case 'w': // u en mac w W
        this.dibujoVehiculo.setY(this.dibujoVehiculo.getY());
        this.dibujoVehiculo.setRotate(270);
        break;
      case 's': // d en mac s W
        this.dibujoVehiculo.setY(this.dibujoVehiculo.getY() );
        this.dibujoVehiculo.setRotate(90);
        break;
      default:
        break;
    }

    this.circle.setCenterY(this.dibujoVehiculo.getY());
    this.circle.setCenterX(this.dibujoVehiculo.getX());

    this.filtro = Shape.subtract(this.capa, this.circle);
    this.filtro = Shape.subtract(this.filtro, this.meta);
    this.group.getChildren().add(this.filtro);

  }
}
