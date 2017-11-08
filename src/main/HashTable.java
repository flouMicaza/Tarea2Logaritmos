package main;

import java.util.ArrayList;

public class HashTable {
  int largo; //largo de la tabla
  int llenado;
  String[] tabla; //tabla con las llaves
  Dicc<ArrayList<Integer>> valores; //lista de los valores
  public HashTable(){
    this.largo=8;
    this.llenado=0;
    this.tabla= new String[largo];
    this.valores=new Dicc<ArrayList<Integer>>(largo);
  }
  
  
  public void dublicarTabla(){
    this.largo=2*this.largo; //duplicamos el largo
    String[] tabla1 = this.tabla; //guardamos una copia de la tabla actual
    Dicc<ArrayList<Integer>> valores1 = this.valores;
    this.tabla=new String[largo]; //agrandamos la tabla
    this.valores=new Dicc<ArrayList<Integer>>(largo);
    //se recorre la tabla actual y se van copiando los valores a la nueva tabla
    for (int i = 0; i < tabla1.length; i++) {
      this.tabla[i]=tabla1[i];
      this.valores.set(i,valores1.obtener(i));
    }
  }
  
  public ArrayList<Integer> buscar(String palabra){
    int indice = this.Hash(palabra); //calculamos la posici�n en la que deber�a ir
    while(this.tabla[indice]!=null){ //buscamos la palabra en la tabla hasta que ya no hayan palabras.
      if(this.tabla[indice].equals(palabra)){ //si encontramos la palabra que buscamos
        //encontre la palabra
        return this.valores.obtener(indice);
      }
      
      else{ //si la palabra no estaba donde la busque
        indice=(indice+1)%this.largo;
      }
    }
    return new ArrayList<Integer>(); //si me salgo del while es q no lo encontre.
  }
  
  
  public void insertar(String palabra, int valor){
    //TODO hacer funcion insertar
  }

  /**
   * Funcion de hash que transforma la palabra en un n�mero y luego encuentra su posici�n en el arreglo
   * @param a = palabra a insertar
   * @return la posici�n en el arreglo
   */
  public int Hash(String a){
    int stringsize = a.length();
    int hashval, j;
    hashval = (int) a.charAt(0);
    for (j = 1; j < stringsize; j++)
      hashval += (int) a.charAt(j);
    return(hashval % this.largo); /* suponiendo que tablesize es global */
   } 
  
  
}
