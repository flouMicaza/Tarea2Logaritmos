package main;

import java.util.ArrayList;

public class NullPatriciaNode implements PatriciaNodeI{
  String key = "";
  PatriciaNode father;
  
  public NullPatriciaNode(PatriciaNode father){
    this.father = father;
  }

  //Si se esta leyendo el final de la palabra entonces la encontramos
  public ArrayList<Integer> buscar(String palabra){
    if (palabra.length() == 0) {
		return father.appearances;
	}
    return new ArrayList<Integer>();
  }
  
  
  //Si se llego al final se crea un nuevo nodo con la cadena restante y se inserta en el padre 
  public void insertar(String palabra, int value){
    father.addValue(value);
    return;
  }

  @Override
  public String getKey() {
    return this.key;
  }

  @Override
  public void setKey(String key) {
    return;
  }

  @Override
  public boolean isNullNode() {
    return true;
  }
}
