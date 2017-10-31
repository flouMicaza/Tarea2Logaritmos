package main;

import java.util.ArrayList;


/**un nodo deberia tener hijos, un par llave y valor. 
 * El valor tiene que ser un arreglo, para que cuando insertemos algo nuevo cn la misma llave
 * se le agregue el valor a la lista de valores nomas. 
 * 
 */

public class ABTNode {
  String key; //llave del diccionario
  ArrayList<Integer> values; //valores asociados a la llave
  ABTNode izq;
  ABTNode der;
  ABTNode centro;
  ABTNode padre; //porsiacaso se necesita para algun arbol
  
  
  /**Contructor de un nodo. 
   * 
   */
  public void Nodo(){
    //TODO constructor nodo
  }


}
