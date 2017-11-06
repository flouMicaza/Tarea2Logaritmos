package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.ABT;
import main.ABTNode;

public class ABTTest {
  
  ABT tree;
  ABTNode centro;
  
  @Before
  public void settings(){
    tree = new ABT("as",1);
    ABTNode raiz = tree.root;
    centro = raiz.center;
  }
  
  @Test 
  public void constructorABTTest(){
    assertNotNull("el arbol no debe ser nulo",tree);
  }
  
  
  @Test
  public void rootNotNullTest(){
    assertNotNull("la raiz no debe ser nula",tree.root);
  }
  
  @Test 
  public void centroNotNullTest(){
    assertNotNull("el del centro no deberia ser nulo",centro);
  }
  
  @Test
  public void buenaConstruccionTest(){
    assertEquals('a',tree.root.getEtiqueta());
  }
  
  @Test
  public void buenaConstruccion2Test(){
    assertEquals('s',centro.getEtiqueta());
  }
  
  @Test
  public void busqueda1Test(){
    ArrayList<Integer> valores = tree.busqueda("as");
    int a = valores.get(0);
    assertEquals(1,a);
  }
  
  @Test
  public void busquedaMalaTest(){
    ArrayList<Integer> valores = tree.busqueda("es");
    int a = valores.size();
    assertEquals(0,a);
  }
  
  @Test
  public void insertarPrimeroTest(){
    tree.insertar("bs", 1);
    ArrayList<Integer> valores = tree.busqueda("bs");
    int a = valores.size();
    int b = valores.get(0);
    
    assertEquals(1,a);
    assertEquals(1,b);
  }
}
