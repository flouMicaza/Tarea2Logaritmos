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
		System.out.println("Llegue a insertar");
	    while (i < n) {
	      System.out.println(i);
	      long timeIni = System.nanoTime();
	      arbol.insertar(palabras[i], i);
	      long timeOut = System.nanoTime();
	      double currentTime = (timeOut-timeIni)/1000000000.0;
	      timeABT += currentTime;
	      System.out.println(currentTime);
	      printerABT.write(Double.toString(currentTime));
		  printerABT.write(System.lineSeparator());
	      i++;
	    }
		System.out.println("Pude insertar");
	    printerABTTotal.write(Float.toString(timeABT) + " para " + n + " palabras");
		printerABTTotal.write(System.lineSeparator());
	  }
	
	  private static void buscar(int n, int i, String[] palabras, Arbol arbol, PrintWriter printerABT, PrintWriter printerABTTotal) {
		  float timeABT = 0;
		  System.out.println("Llegue a buscar");
		  while (i < n) {
			  System.out.println(i);
			  Random rand = new Random();
			  int r = rand.nextInt(n);
			  long timeIni = System.nanoTime();
		      arbol.busqueda(palabras[r]);
		      long timeOut = System.nanoTime();
		      double currentTime = (timeOut-timeIni)/1000000000.0;
		      timeABT += currentTime;
		      printerABT.write(Double.toString(currentTime));
			  printerABT.write(System.lineSeparator());
		      i++;
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
	  
	    List<Integer> indexes = Arrays.asList(10);
	    //List<Integer> indexes = Arrays.asList(1024, 4096, 16384, 65536, 262144, 1048576);
	    String palabra;
	    int value;
	    String file = new Scanner(new File("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/output.txt")).useDelimiter("\\Z").next();
	    String[] palabras = file.split(" ");
	    System.out.println(palabras.length);
	    int i = 0;
	    ABT arbolABT = new ABT(palabras[0],i);
	    HashTable arbolHT = new HashTable(palabras.length);
	    arbolHT.insertar(palabras[0], i);
	    Patricia arbolPT = new Patricia(palabras[0],i);
	    i++;
		printerABTTotal1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/ABTInsertar.txt", "UTF-8");
		printerABTTotal2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/ABTBuscar.txt", "UTF-8");
		printerPTTotal1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/PTInsertar.txt", "UTF-8");
		printerPTTotal2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/PTBuscar.txt", "UTF-8");
		//printerHTTotal1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/HTInsertar.txt", "UTF-8");
		//printerHTTotal2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/HTBuscar.txt", "UTF-8");
	    for (Integer each: indexes) {
		    	try {
		    		printerABT1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/ABTInsertar" + each + ".txt", "UTF-8");
		    		printerABT2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/ABTBuscar" + each + ".txt", "UTF-8");
		    		printerPT1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/PTInsertar" + each + ".txt", "UTF-8");
		    		printerPT2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/PTBuscar" + each + ".txt", "UTF-8");
		    		//printerHT1 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/HTInsertar" + each + ".txt", "UTF-8");
		    		//printerHT2 = new PrintWriter("/Users/user/Desktop/Tarea2Logaritmos/Experimentos/HTBuscar" + each + ".txt", "UTF-8");
		    		System.out.println("Se ha empezado la inserción en los arboles con " + each + " palabras");
		    		generar(each, i, palabras, arbolABT, printerABT1, printerABTTotal1);
		    		generar(each, i, palabras, arbolPT, printerPT1, printerPTTotal1);
		    		//generar(each, i, palabras, arbolHT, printerHT1, printerHTTotal1);
		    		System.out.println("Se ha empezado la búsqueda en los arboles con " + each + " palabras");
		    		buscar(each, i, palabras, arbolABT, printerABT2, printerABTTotal2);
		    		//buscar(each, i, palabras, arbolPT, printerPT2, printerPTTotal2);
		    		//buscar(each, i, palabras, arbolHT, printerHT2, printerHTTotal2);
		    		printerABT1.close();
		    		printerABT2.close();
		    		printerPT1.close();
		    		printerPT2.close();
		    		//printerHT1.close();
		    		//printerHT2.close();
		    	}
		    	catch (Exception e) {}
	    }
	    System.out.println("Se han terminado todas las acciones");
		printerABTTotal1.close();
		printerABTTotal2.close();
		printerPTTotal1.close();
		printerPTTotal2.close();
		//printerHTTotal1.close();
		//printerHTTotal2.close();
	}
}
