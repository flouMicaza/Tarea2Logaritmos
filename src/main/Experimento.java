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

	  public static void generarABTs(int n, int i, String[] palabras, ABT arbol, PrintWriter printerABT, PrintWriter printerABTTotal){
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
	
	  private static void buscarABTs(int n, int i, String[] palabras, ABT arbol, PrintWriter printerABT, PrintWriter printerABTTotal) {
		  float timeABT = 0;
		  while (i < n) {
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
	    
	    List<Integer> indexes = Arrays.asList(1024, 4096, 16384, 65536, 262144, 1048576);
	    //List<Integer> indexes = Arrays.asList(1000,2500,5000,10000,25000,50000,100000);
	    String palabra;
	    int value;
	    String file = new Scanner(new File("/Users/user/Desktop/output.txt")).useDelimiter("\\Z").next();
	    String[] palabras = file.split(" ");
	    System.out.println(palabras.length);
	    int i = 0;
	    ABT arbolABT = new ABT(palabras[0],i);
	    i++;
		printerABTTotal1 = new PrintWriter("/Users/user/Desktop/ABTInsertar.txt", "UTF-8");
		printerABTTotal2 = new PrintWriter("/Users/user/Desktop/ABTBuscar.txt", "UTF-8");
	    for (Integer each: indexes) {
		    	try {
		    		printerABT1 = new PrintWriter("/Users/user/Desktop/ABTInsertar" + each + ".txt", "UTF-8");
		    		printerABT2 = new PrintWriter("/Users/user/Desktop/ABTBuscar" + each + ".txt", "UTF-8");
		    		System.out.println("Se ha empezado la inserción en el arbol con " + each + " palabras");
		    		generarABTs(each, i, palabras, arbolABT, printerABT1, printerABTTotal1);
		    		System.out.println("Se ha empezado la búsqueda en el arbol con " + each + " palabras");
		    		buscarABTs(each, i, palabras, arbolABT, printerABT2, printerABTTotal2);
		    		printerABT1.close();
		    		printerABT2.close();
		    	}
		    	catch (Exception e) {}
	    }
	    System.out.println("Se han terminado todas las acciones");
		printerABTTotal1.close();
		printerABTTotal2.close();
	}
}
