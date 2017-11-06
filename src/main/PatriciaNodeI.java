package main;

import java.util.ArrayList;

public interface PatriciaNodeI {
  
  public String getKey();
  
  public void insertar(String palabra, int value);

  public ArrayList<Integer> buscar(String palabras);
}
