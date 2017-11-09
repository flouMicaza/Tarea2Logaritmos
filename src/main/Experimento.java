package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Experimento {

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
	      if (i%10000 == 0) {
	    	  	System.out.println(i);
	      }
	    }
	    printerABTTotal.write(Float.toString(timeABT) + " para " + n + " palabras");
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
		      if (i%10000 == 0) {
		    	  	System.out.println(i);
		      }
		  }
		  printerABTTotal.write(Float.toString(timeABT) + " para " + n + " palabras");
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
	    List<Integer> indexes = Arrays.asList(1024, 4096, 16384, 65536, 262144, 1000000);
	    //List<Integer> indexes = Arrays.asList(1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576);
	    String file = new Scanner(new File("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/input.txt")).useDelimiter("\\Z").next();
	    String file2 = new Scanner(new File("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/busquedas.txt")).useDelimiter("\\Z").next();
	    String[] palabras = file.split(" ");
	    String[] busqueda = file2.split(" ");
	    System.out.println(palabras.length);
		printerABTTotal1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/ABTInsertar.txt", "UTF-8");
		printerABTTotal2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/ABTBuscar.txt", "UTF-8");
		printerPTTotal1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/PTInsertar.txt", "UTF-8");
		printerPTTotal2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/PTBuscar.txt", "UTF-8");
		printerHTTotal1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/HTInsertar.txt", "UTF-8");
		printerHTTotal2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/HTBuscar.txt", "UTF-8");
	    for (Integer each: indexes) {
		    	try {
		    		int i = 0;
		    	    ABT arbolABT = new ABT(palabras[0],i);
		    	    HashTable arbolHT = new HashTable(palabras.length);
		    	    arbolHT.insertar(palabras[0], i);
		    	    Patricia arbolPT = new Patricia(palabras[0],i);
		    	    i++;
		    		printerABT1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/ABTInsertar" + each + ".txt", "UTF-8");
		    		printerABT2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/ABTBuscar" + each + ".txt", "UTF-8");
		    		printerPT1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/PTInsertar" + each + ".txt", "UTF-8");
		    		printerPT2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/PTBuscar" + each + ".txt", "UTF-8");
		    		printerHT1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/HTInsertar" + each + ".txt", "UTF-8");
		    		printerHT2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/HTBuscar" + each + ".txt", "UTF-8");
		    		System.out.println("Se ha empezado la inserción en ABT con " + each + " palabras");
		    		generar(each, i, palabras, arbolABT, printerABT1, printerABTTotal1);
		    		System.out.println("Se ha empezado la inserción en PT con " + each + " palabras");
		    		generar(each, i, palabras, arbolPT, printerPT1, printerPTTotal1);
		    		System.out.println("Se ha empezado la inserción en HT con " + each + " palabras");
		    		generar(each, i, palabras, arbolHT, printerHT1, printerHTTotal1);
		    		System.out.println("Se ha empezado la búsqueda en ABT con " + each + " palabras");
		    		buscar(each, i, busqueda, arbolABT, printerABT2, printerABTTotal2);
		    		System.out.println("Se ha empezado la búsqueda en PT con " + each + " palabras");
		    		buscar(each, i, busqueda, arbolPT, printerPT2, printerPTTotal2);
		    		System.out.println("Se ha empezado la búsqueda en HT con " + each + " palabras");
		    		buscar(each, i, busqueda, arbolHT, printerHT2, printerHTTotal2);
		    		printerABT1.close();
		    		printerABT2.close();
		    		printerPT1.close();
		    		printerPT2.close();
		    		printerHT1.close();
		    		printerHT2.close();
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
}
