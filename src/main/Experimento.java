package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Experimento {

	  public static void generarABTs(int n, int i, String[] palabras, ABT arbol, PrintWriter printerABT){
	    float timeABT = 0;
	    long timeIni, timeOut;
	    double currentTime;
	    while (i < n) {
	      timeIni = System.nanoTime();
	      arbol.insertar(palabras[i], i);
	      System.out.println(palabras[i]);
	      System.out.println(i);
	      timeOut = System.nanoTime();
	      currentTime = (timeOut-timeIni)/1e6;
	      timeABT += currentTime;
	      printerABT.write(Double.toString(currentTime));
		  printerABT.write(System.lineSeparator());
	      i++;
	    }
	    printerABT.write(System.lineSeparator());
	    printerABT.write(Float.toString(timeABT));
	    printerABT.write(System.lineSeparator());
		printerABT.write(System.lineSeparator());
	  }
	
	  private static void buscarABTs(int n, int i, String[] palabras, ABT arbol, PrintWriter printerABT) {
		  float timeABT = 0;
		  long timeIni, timeOut;
		  double currentTime;
		  while (i < n) {
			  Random rand = new Random();
			  int r = rand.nextInt(n);
			  timeIni = System.nanoTime();
		      arbol.busqueda(palabras[r]);
		      timeOut = System.nanoTime();
		      currentTime = (timeOut-timeIni)/1e6;
		      timeABT += currentTime;
		      printerABT.write(Double.toString(currentTime));
			  printerABT.write(System.lineSeparator());
		      i++;
		  }
		  printerABT.write(System.lineSeparator());
		  printerABT.write(Float.toString(timeABT));
		  printerABT.write(System.lineSeparator());
		  printerABT.write(System.lineSeparator());
	  }

	  public static void main(String[] args) throws FileNotFoundException {
	    //lista de valor con los que probaremos
	    PrintWriter printerABT1 = null; 
	    PrintWriter printerABT2 = null; 

	    List<Integer> indexes = Arrays.asList(20);
	    //List<Integer> indexes = Arrays.asList(1000,2500,5000,10000,25000,50000,100000);
	    String palabra;
	    int value;
	    String file = new Scanner(new File("/Users/user/Desktop/output.txt")).useDelimiter("\\Z").next();
	    String[] palabras = file.split(" ");
	    System.out.println(palabras.length);
	    int i = 0;
	    ABT arbolABT = new ABT(palabras[0],i);
	    i++;
	    for (Integer each: indexes) {
		    	try {
		    		printerABT1 = new PrintWriter("/Users/user/Desktop/ABTInsertar" + each + ".txt", "UTF-8");
		    		printerABT2 = new PrintWriter("/Users/user/Desktop/ABTBuscar" + each + ".txt", "UTF-8");
		    		generarABTs(each, i, palabras, arbolABT, printerABT1);
		    		buscarABTs(each, i, palabras, arbolABT, printerABT2);
		    		printerABT1.close();
		    		printerABT2.close();

		    	}
		    	catch (Exception e) {}
	    }
	}
}
