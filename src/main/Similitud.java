package main;

import java.util.ArrayList;

public class Similitud {
  
  public double similitud(String[] texto1, String[] texto2){
    String[] superTexto = unir(texto1, texto2);
    return 1 - count2(texto1, texto2, superTexto)*1.0/count(superTexto);
  }

  private int count2(String[] texto1, String[] texto2, String[] superTexto) {
    ArrayList<String> t = new ArrayList<String>();
    int cnt = 0;
    for (int j = 0; j < superTexto.length; j++) {
      String palabra = superTexto[j];
      if (!t.contains(palabra)){
        cnt += Math.abs(count(palabra, texto1) - count(palabra, texto2));
        t.add(palabra);
      }
    }
    return cnt;
  }

  private int count(String palabra, String[] texto1) {
    int cnt = 0;
    for (int i = 0; i < texto1.length; i++) {
	  if (palabra.equals(texto1[i])) {
	    cnt++;
	  }
	}
    return cnt;
  }

  private int count(String[] superTexto) {
    return superTexto.length;
  }

  private String[] unir(String[] texto1, String[] texto2) {
    String[] superTexto = new String[texto1.length + texto2.length];
    for (int i = 0; i < texto1.length; i++) 
      superTexto[i] = texto1[i];
    for (int i = texto1.length; i < superTexto.length; i++)
      superTexto[i] = texto2[i - texto1.length];
    return superTexto;
  }
}
