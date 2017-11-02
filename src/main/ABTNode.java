package main;

import java.util.ArrayList;


/**un nodo deberia tener hijos, un par llave y valor. 
 * El valor tiene que ser un arreglo, para que cuando insertemos algo nuevo cn la misma llave
 * se le agregue el valor a la lista de valores nomas. 
 * 
 */

public class ABTNode {
  char etiqueta;
  String key; //llave del diccionario
  ArrayList<Integer> values; //valores asociados a la llave
  ABTNode izq;
  ABTNode der;
  ABTNode center;
  ABTNode father; //porsiacaso se necesita para algun arbol
  int isLeaf;
  
  /**Contructor de un nodo.
   * Solo cuando no es una hoja
   * 
   */
  public ABTNode(ABTNode father,char etiqueta){
    this.isLeaf=0; //este es el constructor para no hojas
    this.izq=null;
    this.der=null;
    this.center=null;
    this.father=father;
    this.etiqueta=etiqueta;
    
  }

  /**Contructor de un nodo.
   * Solo cuando es una hoja
   * 
   */
  public ABTNode(ABTNode father,char etiqueta,String key,int value){
    this.isLeaf=1; //este es el constructor para hojas
    this.izq=null;
    this.der=null;
    this.center=null;
    this.father=father;
    this.etiqueta=etiqueta;
    this.key=key;
    this.values.add(value);
     
  }

  /**
   * Metodo que entrega la etiqueta del nodo (diferente a la key)
   * @return etiqueta del nodo
   */
  public char getEtiqueta() {
    return this.etiqueta;
  }
  
  
  public ArrayList<Integer> busquedaAux(String palabra,int indice){
	 //TODO revisar si los indices estan bien contados cuando se retorna.  
	 
    //si la etiqueda del nodo que estoy visitando es igual a la letra que estoy buscando
    //busco en el del centro
    if(this.getEtiqueta()==palabra.charAt(indice)){
      if(this.center!=null){ //si aun quedan ramas por recorrer
        return this.center.busquedaAux(palabra,indice+1);
      }
      else if (indice==palabra.length()){ //si el hijo es nulo, entonces el string no esta
        return this.values;
      }
      
      else{
    	  return null;
      }
    }
    
    //si la etiqueta del nodo que esty visiando es menor a la letr que estoy viendo
    //voy a buscar al hijo derecho
    else if(this.getEtiqueta()<palabra.charAt(indice)){
      if(this.der!=null){ //si aun quedan ramas por recorrer
        return this.der.busquedaAux(palabra, indice);
      }
      
      else if(indice==palabra.length()){ //si el hijo es nulo y llegue al final
        return this.values;
      }
      
      else return null;
    }
    
    //si la etiqueta del nodo que estoy visitando es mayor a la letra que estoy viendo
    //voy a buscar al hijo izquierdo
    else { //if(this.getEtiqueta()>palabra.charAt(indice))
      if(this.izq!=null){
        return this.izq.busquedaAux(palabra, indice);
      }
      else if(indice==palabra.length()){ //si tengo que buscar a la izq pero no hay nada, entonces el string no esta
        return this.values;
      }
      else return null;
    }
  }
  
  
  /**
   * agregar un valor a la lista de valores para una llave determinada
  
   * @param val : valor a agregar a la key
   */
  public void addValue(int val){

    //si no es una hoja no deber�a estar agregando un valor.
    if(this.isLeaf==0){
      System.out.println("Esta tratando de poner un valor en un nodo que no es hoja!");
      return; 
    }
    else{
      this.values.add(val);
    }
  }

  /**
   * Metodo que entrega la llave asociada a este nodo.
   * @return retorna la llave de este nodo
   */
  public String getKey(){
    if(this.isLeaf==0){
      System.out.println("se esta intentando ver una llave de un nodo que no es hoja");
      return null;
    }
    else
      return this.key;
  }

public boolean insertarNodo(String palabra, int value,int indice) {
	//hacer busqueda en el nodo.
	//si la encuentra hacemos addValue donde quedamos.
	//si le falta por recorrer, lo que sobro lo insertamos como en un trie
	//
	
	//TODO hacer lafuncion insertar entera
	
	
	return false;

}
}
