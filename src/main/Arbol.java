package main;

import java.util.ArrayList;

public abstract class Arbol {

	abstract ArrayList<Integer> busqueda(String palabra);
	abstract void insertar(String palabra, int value);
}
