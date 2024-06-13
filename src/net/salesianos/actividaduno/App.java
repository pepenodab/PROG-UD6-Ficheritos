package net.salesianos.actividaduno;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    boolean keepAsking = true;
    final String PATH = "src/net/salesianos/actividaduno/output/Fichero.txt";
    final File FILE = new File(PATH);

    final Scanner SCANNER = new Scanner(System.in);
    String userText = "";

    while (keepAsking) {
      System.out.println("Porfavor introduzca una cadena de texto de al menos 30 caracteres");
      userText = SCANNER.nextLine();

      if (userText.length() < 30) {
        System.out.println("Usted introdujo " + userText.length() + " caracteres, debe de colocar al menos "
            + (30 - userText.length()) + " caracteres");

      } else {

        System.out.println("-- TEXTO VALIDADO --");
        keepAsking = false;
      }
    }

    final String NEW_TEXT = userText.toUpperCase().replaceAll(" ", "_");

    try {
      final BufferedOutputStream BUFFERED_OUTPUT = new BufferedOutputStream(new FileOutputStream(FILE));
      // https://www.baeldung.com/java-string-to-byte-array
      BUFFERED_OUTPUT.write(NEW_TEXT.getBytes());
      System.out.println("El texto fue creado con exito");
      BUFFERED_OUTPUT.close();
    } catch (EOFException e) {
      SCANNER.close();
      return;
    } catch (IOException e) {
      System.out.println("ERROR al acceso de entrada/salida estandar");
    }

    SCANNER.close();
  }
}