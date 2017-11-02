package main;

import java.util.ArrayList;

//Arbol de busqueda ternario
public class ABT {
  ABTNode root; 
  
  
  public ABT(){
    //TODO crear bien el constructor del Arbol
    this.root=new ABTNode(null,'$');
    
  }
  
  /**
   * Metodo que busca un string en el arbol.
   * @return True y lo encuentra, False si no lo encuentra
   */
  public ArrayList<Integer> busqueda(String palabra){
    palabra.charAt(0); //metodo para sacar el iesimo de la palabra    
    return root.busquedaAux(palabra, 0);
  }
  
  public boolean insertar(String palabra, int value){
	  return this.root.insertarNodo(palabra,value,0);
  }

}
