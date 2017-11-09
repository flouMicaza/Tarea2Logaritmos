package main;

import java.util.ArrayList;

public class HashTable extends Arbol {
  int largo; // largo de la tabla
  int llenado;
  String[] tabla; // tabla con las llaves
  Dicc<ArrayList<Integer>> valores; // lista de los valores

  public HashTable(int largo) {
    this.largo = largo*10/4; //*100/40 
    this.llenado = 0;
    this.tabla = new String[largo];
    this.valores = new Dicc<ArrayList<Integer>>(largo);

  }

/*
  public void dublicarTabla() {
    this.largo = 2 * this.largo; // duplicamos el largo
    String[] tabla1 = this.tabla; // guardamos una copia de la tabla actual
    Dicc<ArrayList<Integer>> valores1 = this.valores;
    this.tabla = new String[largo]; // agrandamos la tabla
    this.valores = new Dicc<ArrayList<Integer>>(largo);
    // se recorre la tabla actual y se van copiando los valores a la nueva tabla
    for (int i = 0; i < tabla1.length; i++) {
      int hash = this.Hash(tabla1[i]);
      this.tabla[hash] = tabla1[i];
      this.valores.set(hash, valores1.obtener(i));
    }
  }*/

  public ArrayList<Integer> busqueda(String palabra) {
    int indice = this.Hash(palabra); // calculamos la posicion en la que deberia ir
    System.out.println("la palabra "+ palabra+ "tiene hash" + indice);
    while (this.tabla[indice] != null) { // buscamos la palabra en la tabla hasta que ya no hayan
                                         // palabras.
      if (this.tabla[indice].equals(palabra)) { // si encontramos la palabra que buscamos
        // encontre la palabra
        return this.valores.obtener(indice);
      }

       
      else { // si la palabra no estaba donde la busque
        indice = (indice + 1) % this.largo;
      }
    }
    return new ArrayList<Integer>(); // si me salgo del while es q no lo encontre.
  }


  // funcion que inserta una palabra y un valor al diccionario
  // si la tabla esta al 40% la duplico y luego inserto.
  public void insertar(String palabra, int valor) {
    

    int indice = Hash(palabra); // indice de donde deberia ir la palabra
   
    //si no hay nada en mi lugar, solo me pongo
    if(this.tabla[indice]==null){
      
      this.tabla[indice] = palabra; // agrego la llave a la tabla
      this.llenado++;
      this.valores.set(indice, new ArrayList<Integer>()); // creo la lista de valores
      this.valores.setValor(indice, valor); // agrego el valor a la lista de valores
      return;
    }
    
    //si esta mi palabra en este lugar
    else if(this.tabla[indice].equals(palabra)){
      //seteo el val en la lista de valores
      this.valores.setValor(indice,valor);     
    }
    //si no hay espaccio  o tengo q buscar mi palabra
    else{
      //mientras no haya un espacio vacio
      while(this.tabla[indice]!=null){
          //busco mi palabra
        if(this.tabla[indice]==palabra){
          this.valores.setValor(indice, valor);
          return;
        }

        indice= (indice+1)%this.largo;

      }
      //cuando sale del while es porque ya llego a un espacio vacio entonces creo un nuevo "nodo"
      this.tabla[indice] = palabra; // agrego la llave a la tabla
      this.llenado++;
      this.valores.set(indice, new ArrayList<Integer>()); // creo la lista de valores
      this.valores.setValor(indice, valor); // agrego el valor a la lista de valores
      return;
    }
    }

  /**
   * Funcion de hash que transforma la palabra en un n�mero y luego encuentra su posici�n en el
   * arreglo
   * 
   * @param a = palabra a insertar
   * @return la posicion en el arreglo
   */
  public int Hash(String a) {
    int stringsize = a.length();
    int hashval, j;
    hashval = (int) a.charAt(0);
    for (j = 1; j < stringsize; j++)
      hashval += (int) a.charAt(j);
    return (hashval % this.largo); /* suponiendo que tablesize es global */
  }


  public int getLargo() {
    
    return this.largo;
  }


  public String[] getTabla() {

    return this.tabla;
  }


  public Dicc<ArrayList<Integer>> getValues() {
    
    return this.valores;
  }


}
