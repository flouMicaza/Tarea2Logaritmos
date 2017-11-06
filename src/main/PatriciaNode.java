package main;

import java.util.ArrayList;

public class PatriciaNode {
  String key;
  ArrayList<Integer> appearances;
  PatriciaNode childs;
  PatriciaNode father;

  //Constructor para nodos no raiz
  public PatriciaNode(String key, PatriciaNode father){
	this.key = key;
	this.appearances = new ArrayList<Integer>();
	this.childs = null;
	this.father = father;
  }
  
  //Constructor para la raiz
  public PatriciaNode(String key){
    this.key = key;
  }

  public ArrayList<Integer> busqueda(String palabra) {
	// TODO Auto-generated method stub
    return null;
  }

}
