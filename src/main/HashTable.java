package main;

import java.util.ArrayList;

public class HashTable extends Arbol {
  int largo; // largo de la tabla
  int llenado;
  String[] tabla; // tabla con las llaves
  Dicc<ArrayList<Integer>> valores; // lista de los valores


  

  public HashTable(int length) {
    this.largo = length*10/4; //*100/40 
    this.llenado = 0;
    this.tabla = new String[largo];
    this.valores = new Dicc<ArrayList<Integer>>(largo);

  }




  public ArrayList<Integer> busqueda(String palabra) {
    int indice = this.Hash(palabra); // calculamos la posicion en la que deberia ir
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
        if(this.tabla[indice].equals(palabra)){
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
	  
	  int h = 11;
	  
		  int off = 0;
		  String val = a;
		  int len = a.length();
		  
		  for (int i = 0; i < len; i++) {
			  h = 31*h+(int)val.charAt(off++);
		  }
		 
	
	  return Math.abs(h%this.largo);
	  
    /*
	  int stringsize = a.length();
      int hashval = 11;
      int j;
      hashval = (int) a.charAt(0);
      for (j = 1; j < stringsize; j++){
      	//hashval *= 31;
      	hashval += (int) a.charAt(j);
    	System.out.println(this.largo);
      }
      return (hashval % this.largo);
      */
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
