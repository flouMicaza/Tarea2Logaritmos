package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Experimento {

	  //metodo que escribe en un archivo la cantidad de accesos a disco en la busqueda y el tiempo que se demora por cada query
	  private static void generarQueries(int n, ABT arbol, PrintWriter printerABT) {
	    float timeABT = 0;
	    long accesosABT = 0;
	    long timeIni, timeOut;
	    long tf;
	    for (int i = 0; i < n-1; i++) {
	      timeIni = System.nanoTime();
	      //tiempo que se quiere medir
	      int medible = 0;
	      int medible2 = 0;
	      timeOut = System.nanoTime();
	      tf = timeOut - timeIni;
	      timeABT += tf;
	      accesosABT += medible2; 
	      printerABT.write("Accesos a memoria: " + medible + "   Tiempo de busqueda: " + tf + " nanosegundos");
	      printerABT.write(System.lineSeparator());
	    }
	    timeABT /= 1000000000.0;
	    printerABT.write("Tiempo promedio de busqueda total: " + timeABT/n + "  segundos");
	    printerABT.write(System.lineSeparator());
	    printerABT.write("Accesos promedio a memoria: " + accesosABT/n );
	    printerABT.write(System.lineSeparator());
	  }

	  public static void generarABTs(int i, String[] palabras, ABT arbol, PrintWriter printerABT){
	    float timeABT = 0;
	    long timeIni, timeOut;
	    while (i < 20) {
	      timeIni = System.currentTimeMillis();
	      arbol.insertar(palabras[i], i);
	      System.out.println(palabras[i]);
	      System.out.println(i);
	      timeOut = System.nanoTime();
	      double currentTime = (timeOut-timeIni)/1000000000.0;
	      timeABT += currentTime;
	      printerABT.write(Double.toString(currentTime));
		  printerABT.write(System.lineSeparator());
	      i++;
	    }
	    printerABT.write(System.lineSeparator());
	    printerABT.write(Float.toString(timeABT));
	    printerABT.write(System.lineSeparator());
	  }
	  
	  public static void main(String[] args) throws FileNotFoundException {
	    //lista de valor con los que probaremos
	    PrintWriter printerABT = null; 

	    List<Integer> indexes = Arrays.asList(100);
	    //List<Integer> indexes = Arrays.asList(1000,2500,5000,10000,25000,50000,100000);
	    String palabra;
	    int value;
	    String file = new Scanner(new File("/Users/user/Desktop/output.txt")).useDelimiter("\\Z").next();
	    String[] palabras = file.split(" ");
	    System.out.println(palabras.length);
	    int i = 0;
	    ABT arbolABT = new ABT(palabras[0],i);
	    i++;
	    	try {
	    		printerABT = new PrintWriter("/Users/user/Desktop/ABT.txt", "UTF-8");
	    		generarABTs(i, palabras, arbolABT, printerABT);
	    		printerABT.close();
	    	}
	    	catch (Exception e) {}
	}
}
