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
	childs.add(new NullPatriciaNode(this));
	this.father = father;
  }
  
  //Constructor para la raiz
  public PatriciaNode(String key){	
    this.key = key;
    this.childs = new ArrayList<PatriciaNodeI>();
    childs.add(new NullPatriciaNode(this));
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
	    //Se calcula el prefijo maximo
	    String prefijo = minPrefijo(palabra, key);
	    //Se crean lo nuevos nodos
	    PatriciaNode pNode1 = new PatriciaNode(palabra.substring(prefijo.length(), palabra.length() - 1), (PatriciaNode) node);
	    PatriciaNode pNode2 = new PatriciaNode(key.substring(prefijo.length(), key.length() - 1), (PatriciaNode) node);
	    //Se cambian los hijos de el nodo actual a uno de los nuevos nodos
	    pNode2.childs.addAll(childs);
	    PatriciaNode node2 = (PatriciaNode) node;
	    //Se limpia los hijos de este nodo y se agregan los dos nuevos creados
	    node2.childs = new ArrayList<PatriciaNodeI>();
	    node2.childs.add(pNode1);
	    node2.childs.add(pNode2);
	    node.setKey(prefijo);
	  }
	}
    //Se crea el nodo y se inserta en los hjos
    PatriciaNode pNode = new PatriciaNode(palabra, this);
    pNode.addValue(value);
    childs.add(pNode);
  }
  
  
  //Devuelve el prefijo mayor
  private String minPrefijo(String palabra, String key2) {
    int min = (palabra.length() < key2.length())?palabra.length():key2.length();
    int prefijo = 0;
    //Recorro los strings hasta encontrar una letra en que difieran
    for (int i = 1; i < min; i++) {
	  if(palabra.substring(i).equals(key2.substring(i))){
	    prefijo++;
	  }
	  else{
	    break;
	  }
	}
    //Retorno el prefijo maximo
    return key2.substring(prefijo);
  }

  public void addValue(int value){
    this.appearances.add(value);
  }

  @Override
  public String getKey() {
    return this.key;
  }

  @Override
  public void setKey(String key) {
    this.key = key;
  }
}
