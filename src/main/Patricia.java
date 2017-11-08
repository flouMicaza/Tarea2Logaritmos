package main;

import java.util.ArrayList;

public class Patricia extends Arbol {
  PatriciaNode root;
  
  
  public Patricia(String palabra, int value){
	root = new PatriciaNode("0");
	root.childs.clear();
	root.childs.add(new PatriciaNode(palabra, root, value));
  }
  
  //La busqueda se realiza en los nodos
  public ArrayList<Integer> busqueda(String palabra) {
	return root.buscar(palabra);
  }
  
  //La insercion se realiza en los nodos
  public void insertar(String palabra, int value){
    root.insertar(palabra, value);
  }
  
  public PatriciaNode getRoot(){
    return this.root;
  }
  
}
