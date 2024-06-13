package net.salesianos.actividadtres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {

  public static void main(String[] args) {

    final String PATH_ONE = "src/net/salesianos/actividaduno/output/Fichero.txt";

    final String PATH_TWO = "src/net/salesianos/actividaddos/input/Rebeldia.txt";

    final String PATH_THREE = "src/net/salesianos/actividadtres/output/texto.txt";

    final File FILE = new File(PATH_THREE);

    try {
      final BufferedReader BUFFERED_READER_ONE = new BufferedReader(new FileReader(PATH_ONE));

      String fileContentOne = "- Contenido del Fichero Uno: <" + BUFFERED_READER_ONE.readLine() + ">\n";

      final BufferedWriter BUFFERED_WRITER = new BufferedWriter(new FileWriter(FILE));

      BUFFERED_WRITER.write(fileContentOne);

      final BufferedReader BUFFERED_READER_TWO = new BufferedReader(new FileReader(PATH_TWO));

      String fileContentTwo = "- Contenido del Fichero Dos: <" + BUFFERED_READER_TWO.readLine() + ">\n";

      String signaturePepeAndMe = "MarcoElPibeDeJava y su coleguisimo el hijo de Alexis pepenodab firman esta copia para que sepas que es la mejor copia que veras nunca y para asegurar que es irrepetible e intransferible.";

      BUFFERED_WRITER.write(fileContentTwo);

      BUFFERED_WRITER.newLine();
      BUFFERED_WRITER.write(signaturePepeAndMe);

      BUFFERED_READER_ONE.close();
      BUFFERED_READER_TWO.close();
      BUFFERED_WRITER.close();
    } catch (EOFException e) {
      return;
    } catch (IOException e) {
      System.out.println("ta mal");
    }
  }
}