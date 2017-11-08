package main;

import java.util.ArrayList;

public class PatriciaNode implements PatriciaNodeI{
  String key;
  public ArrayList<Integer> appearances;
  public ArrayList<PatriciaNodeI> childs;
  PatriciaNode father;

  //Constructor para nodos no raiz
  public PatriciaNode(String key, PatriciaNode father, int value){
	this.key = key;
	this.appearances = new ArrayList<Integer>();
	if(value != 0)
	  this.addValue(value);
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
      if (node.getKey().equals(palabra.substring(0, len ))) {
        return node.buscar(palabra.substring(len, palabra.length()));
	  }
	}
    return new ArrayList<Integer>();
  }

  public void insertar(String palabra, int value) {
    int len;
    String key;
    for (PatriciaNodeI node : childs) {
      key = node.getKey();
      len = key.length();
      if(!palabra.equals("") && !node.isNullNode()){
	      //Si la primera letra coincide se analizan algunos casos
		  if(key.charAt(0) == palabra.charAt(0)){
			//Caso en que la cadena coincida, se hace recurcion en el nodo
		    if(len <= palabra.length() && key.equals(palabra.substring(0, len))){
		      node.insertar(palabra.substring(len, palabra.length()), value);
		      return;
		    }
		    //Se calcula el prefijo maximo
		    String prefijo = minPrefijo(palabra, key);
		    //Se crean lo nuevos nodos
		    PatriciaNode node2 = (PatriciaNode) node;
		    PatriciaNode pNode1 = new PatriciaNode(palabra.substring(prefijo.length(), palabra.length()), (PatriciaNode) node, value);
		    int app = (node2.appearances.size()==0)?-1:0;
		    //TODO falta arreglar esta cosa de las apariciones justo arriba y algo con l abusqueda de la palabra este$
		    PatriciaNode pNode2 = new PatriciaNode(key.substring(prefijo.length(), key.length()), (PatriciaNode) node, app);
		    //Se cambian los hijos de el nodo actual a uno de los nuevos nodos
		    pNode2.addChilds(node2.childs);
		    //Se limpia los hijos de este nodo y se agregan los dos nuevos creados
		    node2.childs = new ArrayList<PatriciaNodeI>();
		    node2.childs.add(pNode1);
		    node2.childs.add(pNode2);
		    node.setKey(prefijo);
		    node2.appearances.clear();
		    return;
		  }
		}
      else {
        if(node.isNullNode())
          node.insertar(palabra, value);
        return;
      }
    }
    //Se crea el nodo y se inserta en los hjos
    PatriciaNode pNode = new PatriciaNode(palabra, this, value);
    childs.add(pNode);
  }
  
  
  private void addChilds(ArrayList<PatriciaNodeI> childs2) {
    for (PatriciaNodeI node : childs2) {
	  if(!node.isNullNode()){
	    this.childs.add(node);
	  }
	}
  }

  //Devuelve el prefijo mayor
  private String minPrefijo(String palabra, String key2) {
    int min = (palabra.length() < key2.length())?palabra.length():key2.length();
    int prefijo = 0;
    //Recorro los strings hasta encontrar una letra en que difieran
    for (int i = 1; i < min; i++) {
	  if(palabra.substring(i, i + 1).equals(key2.substring(i, i + 1))){
	    prefijo++;
	  }
	  else{
	    break;
	  }
	}
    //Retorno el prefijo maximo
    return key2.substring(0, prefijo + 1);
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

  @Override
  public boolean isNullNode() {
    return false;
  }
}
