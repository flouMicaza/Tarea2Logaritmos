package main;

import java.util.ArrayList;

public class PatriciaNode {
  String key;
  ArrayList<Integer> appearances;
  ArrayList<PatriciaNode> childs;
  PatriciaNode father;

  //Constructor para nodos no raiz
  public PatriciaNode(String key, PatriciaNode father){
	this.key = key;
	this.appearances = new ArrayList<Integer>();
	this.childs = new ArrayList<PatriciaNode>();
	this.father = father;
  }
  
  //Constructor para la raiz
  public PatriciaNode(String key){	
    this.key = key;
    this.childs = new ArrayList<PatriciaNode>();
    this.father = null;
  }

  public ArrayList<Integer> busqueda(String palabra) {
	int len;
	for (PatriciaNode node : childs) {
	  len = node.key.length();
	  //Si coincide la llave con el siguiente prefijo de la palabra entonces hacemos recursion
      if (node.key.equals(palabra.substring(len - 1))) {
        node.busqueda(palabra.substring(len, palabra.length()));
	  }
	}
    return new ArrayList<Integer>();
  }

}
