package main;

import java.util.ArrayList;

public class Dicc<T> {
  Object[] arreglo;

  
  //Arreglo de Objetos con cierta capacidad
  public Dicc(int capacidad) {
      arreglo = new Object[capacidad];
  }
  
  //Al obtener el i-esimo lo casteo a su tipo. 
  public T obtener(int indice) {
      //agrega validaciones correspondientes
      return (T) arreglo[indice];
  }

  //setea un valor dentro de un arraylist
  public void setValor(int indice, int valor) {
    ArrayList<Integer> arr = (ArrayList<Integer>)this.arreglo[indice];
    arr.add(valor);
  }
  
  //setea un valor dentro del arreglo
  public void set(int indice, ArrayList<Integer> valor) {
   this.arreglo[indice]=valor;
  }
}