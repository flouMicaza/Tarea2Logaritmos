package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Experimento {
	  static String directorio = "/Users/sapel/workspace/Tarea2Logaritmos/Experimentos/";

	  public static void generar(int n, int i, String[] palabras, Arbol arbol, PrintWriter printerABT, PrintWriter printerABTTotal){
	    float timeABT = 0;
	    while (i < n) {
	      long timeIni = System.nanoTime();
	      arbol.insertar(palabras[i], i);
	      long timeOut = System.nanoTime();
	      double currentTime = (timeOut-timeIni)/1000000000.0;
	      timeABT += currentTime;
	      printerABT.write(Double.toString(currentTime));
		  printerABT.write(System.lineSeparator());
	      i++;
	    }
	    printerABTTotal.write(Float.toString(timeABT));
		printerABTTotal.write(System.lineSeparator());
	  }
	
	  private static void buscar(int n, int i, String[] palabras, Arbol arbol, PrintWriter printerABT, PrintWriter printerABTTotal) {
		  float timeABT = 0;
		  while (i < n) {
			  long timeIni = System.nanoTime();
		      arbol.busqueda(palabras[i]);
		      long timeOut = System.nanoTime();
		      double currentTime = (timeOut-timeIni)/1000000000.0;
		      timeABT += currentTime;
		      printerABT.write(Double.toString(currentTime));
			  printerABT.write(System.lineSeparator());
		      i++;
		  }
		  printerABTTotal.write(Float.toString(timeABT));
		  printerABTTotal.write(System.lineSeparator());
	  }

	  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	    //lista de valor con los que probaremos
	    PrintWriter printerABT1 = null; 
	    PrintWriter printerABT2 = null; 
	    PrintWriter printerABTTotal1 = null; 
	    PrintWriter printerABTTotal2 = null; 

	    PrintWriter printerPT1 = null; 
	    PrintWriter printerPT2 = null; 
	    PrintWriter printerPTTotal1 = null; 
	    PrintWriter printerPTTotal2 = null; 
	    
	    PrintWriter printerHT1 = null; 
	    PrintWriter printerHT2 = null; 
	    PrintWriter printerHTTotal1 = null; 
	    PrintWriter printerHTTotal2 = null; 
	  
	    //List<Integer> indexes = Arrays.asList(1000000);
	    //List<Integer> indexes = Arrays.asList(1024, 4096, 16384, 65536, 262144);
	    List<Integer> indexes = Arrays.asList(1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288);
	    //List<Integer> indexes = Arrays.asList(1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576);
	    String file = new Scanner(new File(directorio + "input.txt")).useDelimiter("\\Z").next();
	    String file2 = new Scanner(new File(directorio + "busquedas.txt")).useDelimiter("\\Z").next();
	    String[] palabras = file.split(" ");
	    String[] busqueda = file2.split(" ");
	    System.out.println(palabras.length);
		printerABTTotal1 = new PrintWriter(directorio + "ABTInsertar.txt", "UTF-8");
		printerABTTotal2 = new PrintWriter(directorio + "ABTBuscar.txt", "UTF-8");
		printerPTTotal1 = new PrintWriter(directorio + "PTInsertar.txt", "UTF-8");
		printerPTTotal2 = new PrintWriter(directorio + "PTBuscar.txt", "UTF-8");
		printerHTTotal1 = new PrintWriter(directorio + "HTInsertar.txt", "UTF-8");
		printerHTTotal2 = new PrintWriter(directorio + "HTBuscar.txt", "UTF-8");
	    for (Integer each: indexes) {
		    	try {
		    		int i = 0;
		    	    ABT arbolABT = new ABT(palabras[0],i);
		    	    HashTable arbolHT = new HashTable(palabras.length);
		    	    arbolHT.insertar(palabras[0], i);
		    	    Patricia arbolPT = new Patricia(palabras[0],i);
		    	    ABT arbolABT2 = new ABT(palabras[0],i);
		    	    i++;
		    		printerABT1 = new PrintWriter(directorio + "ABTInsertar" + each + ".txt", "UTF-8");
		    		printerABT2 = new PrintWriter(directorio + "ABTBuscar" + each + ".txt", "UTF-8");
		    		printerPT1 = new PrintWriter(directorio + "PTInsertar" + each + ".txt", "UTF-8");
		    		printerPT2 = new PrintWriter(directorio + "PTBuscar" + each + ".txt", "UTF-8");
		    		printerHT1 = new PrintWriter(directorio + "HTInsertar" + each + ".txt", "UTF-8");
		    		printerHT2 = new PrintWriter(directorio + "HTBuscar" + each + ".txt", "UTF-8");
		    		System.out.println("Se está empezando la inserción de " + each + " palabras en ABT1");
		    		generar(each, i, palabras, arbolABT, printerABT1, printerABTTotal1);
		    		System.out.println("Se está empezando la inserción de " + each + " palabras en ABT2");
		    		generar(each, i, busqueda, arbolABT2, printerABT1, printerABTTotal1);
		    		System.out.println("Se está empezando la inserción de " + each + " palabras en PT");
		    		generar(each, i, palabras, arbolPT, printerPT1, printerPTTotal1);
		    		System.out.println("Se está empezando la inserción de " + each + " palabras en HT");
		    		generar(each, i, palabras, arbolHT, printerHT1, printerHTTotal1);
		    		System.out.println("Se está empezando la búsqueda de " + each + " palabras en ABT");
		    		buscar(each, i, busqueda, arbolABT, printerABT2, printerABTTotal2);
		    		System.out.println("Se está empezando la búsqueda de " + each + " palabras en PT");
		    		buscar(each, i, busqueda, arbolPT, printerPT2, printerPTTotal2);
		    		System.out.println("Se está empezando la búsqueda de " + each + " palabras en HT");
		    		buscar(each, i, busqueda, arbolHT, printerHT2, printerHTTotal2);
		    		printerABT1.close();
		    		printerABT2.close();
		    		printerPT1.close();
		    		printerPT2.close();
		    		printerHT1.close();
		    		printerHT2.close();
		    		if (each == 524288){
		    		    System.out.println(similitud(palabras, busqueda,arbolABT,arbolABT2));
		    		}
		    	}
		    	catch (Exception e) {}
	    }
	    System.out.println("Se han terminado todas las acciones");
		printerABTTotal1.close();
		printerABTTotal2.close();
		printerPTTotal1.close();
		printerPTTotal2.close();
		printerHTTotal1.close();
		printerHTTotal2.close();
	}

	private static double similitud(String[] palabras, String[] busqueda, ABT arbolABT, ABT arbol2) {
	  return 1 - count(palabras, busqueda, arbolABT, arbol2)*1.0/(2*524288);
	}

	private static double count(String[] palabras, String[] busqueda, ABT arbolABT, ABT arbol2) {
		ArrayList<String> l = new ArrayList<String>();
		double cnt = 0;
		System.out.println("primer texto");
		for (int i = 0; i < 524288; i++) {
			if(i%10000 == 0)
				System.out.println(i);
			if(!l.contains(busqueda[i])){
				l.add(busqueda[i]);
			}
		}
		System.out.println("Sgundo texto");
		for (int i = 0; i < 524288; i++) {
			if(i%10000==0)
				System.out.println(i);
			if(!l.contains(palabras[i])){
				l.add(palabras[i]);
			}
		}
		for (String word : l) {
			cnt += Math.abs(arbolABT.busqueda(word).size() - arbol2.busqueda(word).size());
		}
		return cnt;
	}
}
