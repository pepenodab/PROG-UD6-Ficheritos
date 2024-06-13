package net.salesianos.actividadcuatro.Mesa;

import java.io.Serializable;

public class Table implements Serializable {
  private String colour;
  private int nLegs;

  public Table(String colour, int nLegs) {
    this.colour = colour;
    this.nLegs = nLegs;
  }

  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public int getnLegs() {
    return nLegs;
  }

  public void setnLegs(int nLegs) {
    this.nLegs = nLegs;
  }

  @Override
  public String toString() {
    return "Tu mesita es de color " + this.colour + " y la cabrona tiene " + this.nLegs + " de patas";
  }

}
