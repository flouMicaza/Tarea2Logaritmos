package main;

import java.util.ArrayList;

public class PatriciaNode implements PatriciaNodeI{
  String key;
  ArrayList<Integer> appearances;
  ArrayList<PatriciaNodeI> childs;
  PatriciaNode father;

  //Constructor para nodos no raiz
  public PatriciaNode(String key, PatriciaNode father){
	this.key = key;
	this.appearances = new ArrayList<Integer>();
	this.childs = new ArrayList<PatriciaNodeI>();
	this.father = father;
  }
  
  //Constructor para la raiz
  public PatriciaNode(String key){	
    this.key = key;
    this.childs = new ArrayList<PatriciaNodeI>();
    this.father = null;
  }

  public ArrayList<Integer> buscar(String palabra) {
	int len;
	for (PatriciaNodeI node : childs) {
	  len = node.getKey().length();
	  //Si coincide la llave con el siguiente prefijo de la palabra entonces hacemos recursion
      if (node.getKey().equals(palabra.substring(len - 1))) {
        return node.buscar(palabra.substring(len, palabra.length() - 1));
	  }
	}
    return new ArrayList<Integer>();
  }

  public void insertar(String palabra, int value) {
    int len;
    for (PatriciaNodeI node : childs) {
      len = key.length();
      //Si la primera letra cincide se analizan algunos casos
	  if(key.charAt(0) == palabra.charAt(0)){
		//Caso en que la cadena coincida, se hace recurcion en el nodo
	    if(key.equals(palabra.substring(len - 1))){
	      node.insertar(palabra.substring(len, palabra.length() - 1), value);
	      return;
	    }
	    //TODO Caso en que no coincida completamente la cadena
	  }
	}
    //Se crea el nodo y se inserta en los hjos
    PatriciaNode pNode = new PatriciaNode(palabra, this);
    pNode.addValue(value);
    childs.add(pNode);
  }
  
  
  
  public void addValue(int value){
    this.appearances.add(value);
  }

  @Override
  public String getKey() {
    return this.key;
  }
}
