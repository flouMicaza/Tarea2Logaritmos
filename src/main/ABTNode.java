package main;

import java.util.ArrayList;


/**un nodo deberia tener hijos, un par llave y valor. 
 * El valor tiene que ser un arreglo, para que cuando insertemos algo nuevo cn la misma llave
 * se le agregue el valor a la lista de valores nomas. 
 * 
 */

public class ABTNode {
  String etiqueta;
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
  public void Nodo(ABTNode father,String etiqueta){
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
   */public void Nodo(ABTNode father,String etiqueta,String key,int value){
    this.isLeaf=1; //este es el constructor para hojas
    this.izq=null;
    this.der=null;
    this.center=null;
    this.father=father;
    this.etiqueta=etiqueta;
    this.key=key;
    this.values.add(value);
     
  }
}
