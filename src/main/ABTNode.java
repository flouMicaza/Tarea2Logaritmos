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
  public ABTNode der;
  public ABTNode center;
  public ABTNode father; //porsiacaso se necesita para algun arbol
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
    this.values=new ArrayList<Integer>();
    
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
    this.values= new ArrayList<Integer>();
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
    	if(palabra.length()-1==indice){ //o indice -1????
    		//encontre la palabra
    		return this.values;
    	}
    	else if(this.center!=null){ //si aun quedan ramas por recorrer
    		return this.center.busquedaAux(palabra,indice+1);
    	}
      
      
    	else{ //ya no quedan mas ramas por recorrer
    		return new ArrayList<Integer>();
      }
    }
    
    //si la etiqueta del nodo que esty visiando es menor a la letr que estoy viendo
    //voy a buscar al hijo derecho
    else if(this.getEtiqueta()<palabra.charAt(indice)){
      if(this.der!=null){ //si aun quedan ramas por recorrer
        return this.der.busquedaAux(palabra, indice);
      }
      
      else{  //ya no queda nada por recorrer asi que devuelvo vacio
    	  return new ArrayList<Integer>();
      }
      
    }
    
    //si la etiqueta del nodo que estoy visitando es mayor a la letra que estoy viendo
    //voy a buscar al hijo izquierdo
    else { //if(this.getEtiqueta()>palabra.charAt(indice))
      if(this.izq!=null){ //aun quedan ramas por recorrer
        return this.izq.busquedaAux(palabra, indice);
      }
      else return new ArrayList<Integer>();
    }
 }
  
  
  /**
   * agregar un valor a la lista de valores para una llave determinada
  
   * @param val : valor a agregar a la key
   */
  public void addValue(int val){

    //si no es una hoja no deberia estar agregando un valor.
    
      this.values.add(val);
    
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

public void insertarNodo(String palabra, int value,int indice) {

   //si las letras son iguales, busco en el centro
	if(this.getEtiqueta()==palabra.charAt(indice)){
	  //si la palabra ya esta, le agregamos el valor a la lista de sus valores
	  if(indice==palabra.length()-1){
	    this.addValue(value);
	  }
	  
	  //si  puedo seguir buscando
	  if(this.center!=null){

	      this.center.insertarNodo(palabra, value, indice+1);
	      return;
	  }
	  //si ya no la encontre
	  else{
	    //creo la cadena con todas las letras
	    this.crearTrie(palabra,value,indice,"Center");
	    return;
	  }
	}
	
	//si la etiqueta es menor a la letra de la palabra:
	else if(this.getEtiqueta()<palabra.charAt(indice)){
	  if(this.der!=null){
	    this.der.insertarNodo(palabra, value, indice);
	  }
	  
	  else{
	    this.crearTrie(palabra, value, indice,"Der");
	  }
	}
	
	// si la etiqueta es mayor a  la letra de la palabra:
	else{
	  if(this.izq!=null){
	    this.izq.insertarNodo(palabra, value, indice);	
	  }
	  else{
	    this.crearTrie(palabra, value, indice,"Izq");
	  }
	}
}


/**
 * Metodo que crea un arbol en que cada nodo tiene una letra de la palbra restante
 * desde el indice al final.
 * @param palabra palabra a insertar
 * @param value valor asociado a la palabra
 * @param indice indice desde el cual empezamos a agregar
 */
public void crearTrie(String palabra, int value, int indice,String lado) {  
  if(lado=="Center"){
    System.out.println("el indice en crear trie es:" + indice);
    System.out.println("la letra a insertar es: " + palabra.charAt(indice));
    this.center=new ABTNode(this,palabra.charAt(indice));
    if(indice==palabra.length()-1){
     //terminamos de agregar palabras, retornamos
     this.center.addValue(value);
     return;
    }
    
    else{
      //agregamos el resto de las letras de la palabra
      this.center.crearTrie(palabra, value, indice+1, "Center");
      return;
    }
  }
  
  else if(lado=="Der"){
    this.der=new ABTNode(this,palabra.charAt(indice));
    if(indice==palabra.length()-1){
      //terminamos de agregar palabras, retornamos
      this.der.addValue(value);
      return;
    }
    else{

      this.der.crearTrie(palabra, value, indice+1, "Center");
      return; 
    }
  }
  //lado == Izq
  else{
    this.izq=new ABTNode(this,palabra.charAt(indice));
    if(indice==palabra.length()-1){
      //terminamos de agregar palabras, retornamos
      this.izq.addValue(value);
      return;
    }
    else{

      this.izq.crearTrie(palabra, value, indice+1, "Center");
      return; 
    }
  }
}


}