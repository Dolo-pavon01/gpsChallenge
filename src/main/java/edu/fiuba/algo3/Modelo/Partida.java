package edu.fiuba.algo3.Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
  private ArrayList<String> podio_viejo = new ArrayList<String>();

  public ArrayList<String> actualizarPodio(String nickname, Integer puntaje) {
    // Leer el archivo
    this.leer_archivo();
    this.podio_viejo.add("Jugador: " + nickname + " Puntaje: " + puntaje);
    // Escribo el archivo
    this.escribir_archivo();
    // Leer
    this.podio_viejo = new ArrayList<String>();
    this.leer_archivo();
    return this.podio_viejo;
  }

  public void leer_archivo() {
    System.out.println("Voy a comenzar a leer el archivo 'Rankings.txt'");
    try {
      File myObj = new File("src/main/java/edu/fiuba/algo3/rankings.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        // this.podio_viejo.add(data);
        this.podio_viejo.add(data.replaceAll("\\n", ""));
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Ocurrió un error.");
      e.printStackTrace();
    }
  }

  public void escribir_archivo() {
    try {
      FileWriter myWriter = new FileWriter("src/main/java/edu/fiuba/algo3/rankings.txt");
      for (int i = 0; i < this.podio_viejo.size(); i++) {
        myWriter.write(i + this.podio_viejo.get(this.podio_viejo.size() - 1 - i) + "\n");
        System.out.println("Se abrió con Exito el archivo.");
      }
      myWriter.close();
    } catch (IOException e) {
      System.out.println("Ocurrió un erro al intentar el archivo.");
      e.printStackTrace();
    }
  }
}
