package main;

import java.util.ArrayList;

public class Patricia {
  PatriciaNode root;
  
  
  public Patricia(){
	root = new PatriciaNode("0");
  }
  
  //La busqueda se realiza en los nodos
  public ArrayList<Integer> busqueda(String palabra) {
	return root.buscar(palabra);
  }
  
  //La insercion se realiza en los nodos
  public void insertar(String palabra, int value){
    root.insertar(palabra, value);
  }
  
}
