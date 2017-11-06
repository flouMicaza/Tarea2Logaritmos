package main;

import java.util.ArrayList;

//Arbol de busqueda ternario
public class ABT {
  ABTNode root; 
  
  //se crea un arbol conociendo la primera palabra
  public ABT(String palabra,int value){
    //TODO crear bien el constructor del Arbol
    this.root=new ABTNode(null,palabra.charAt(0));
    
    //se insertan todas las letras de la palabra en el nodo, desde la segunda letra
    this.root.crearTrie(palabra,value,1,"Center");
   
  }
  
  /**
   * Metodo que busca un string en el arbol.
   * @return True y lo encuentra, False si no lo encuentra
   */
  public ArrayList<Integer> busqueda(String palabra){
    return root.busquedaAux(palabra, 0);
  }
  
  /**
   * Método que inserta una keyword y un valor
   * @param palabra string keyword
   * @param value valor asociado a la llave
   * 
   */  
  public void insertar(String palabra, int value){
	//inserta la llave y el valor.   
    this.root.insertarNodo(palabra,value,0);
  }

}
