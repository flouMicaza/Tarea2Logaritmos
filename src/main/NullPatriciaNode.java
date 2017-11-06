package main;

import java.util.ArrayList;

public class NullPatriciaNode {
  String key = "$";
  PatriciaNode father;
  
  public NullPatriciaNode(PatriciaNode father){
    this.father = father;
  }

  //Si se esta leyendo el final de la palabra entonces la encontramos
  public ArrayList<Integer> busqueda(String palabra){
    if (palabra.equals("$")) {
		return father.appearances;
	}
    return new ArrayList<Integer>();
  }
}
