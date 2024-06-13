package net.salesianos.actividadcuatro;

import java.io.Console;

import net.salesianos.actividadcuatro.utils.Utils;

public class App {
  public static void main(String[] args) throws Exception {
    boolean keepAsking = true;
    int userOption;
    final Console CONSOLE = System.console();

    while (keepAsking) {
      System.out.println("================================");
      System.out.println(" 1.- Guardar mesa");
      System.out.println(" 2.- Mostrar todas las mesas");
      System.out.println("\t 3.- Salir");
      System.out.println("================================");
      userOption = Integer.parseInt(CONSOLE.readLine());

      switch (userOption) {
        case 1:
          Utils.saveTable();
          break;

        case 2:
          Utils.showTable();

          break;

        case 3:
          keepAsking = false;
          break;
        default:
          break;
      }
    }

  }
}
