package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Patricia;
import main.PatriciaNode;

public class PatriciaTest {

  Patricia tree;
  
  
  @Before
  public void settings(){
    tree = new Patricia("roma$", 1);
  }
  
  @Test
  public void constructorTest(){
    assertNotNull("El arbol no debe ser nulo", tree);
  }
  
  @Test
  public void keyTest(){
    assertEquals("El valor de la raiz debe ser 0", "0", tree.getRoot().getKey());
  }
  
  @Test
  public void hijoTest(){
    assertEquals("El valor del hijo debe ser roma$", "roma$", tree.getRoot().childs.get(0).getKey());
    assertEquals("Debe tener un hjo", 1, tree.getRoot().childs.size());
  }
  
  @Test
  public void insertarTest(){
    tree.insertar("papa$", 2);
    assertEquals("El nodo debe tener un hijo", 2, tree.getRoot().childs.size());
    assertEquals("la llave debe ser ro ahora", "papa$", tree.getRoot().childs.get(1).getKey());
  }
  
  @Test
  public void insertarTest2(){
    tree.insertar("roma$", 6);
    PatriciaNode p = (PatriciaNode) tree.getRoot().childs.get(0);
    assertEquals("Debe tener dos apariciones", 2, p.appearances.size());
    assertEquals("El segundo valor debe ser 6", 6, (int)p.appearances.get(1));
  }
  
  @Test
  public void insertarTest3(){
    tree.insertar("ro$", 2);
    assertEquals("La nueva key debe ser ro", "ro", tree.getRoot().childs.get(0).getKey());
  }
  
  @Test
  public void insertarTest4(){
    tree.insertar("perro$", 2);
    tree.insertar("pera$", 3);
    assertEquals("Debe haber 2 nodos colgando de la raiz", 2, tree.getRoot().childs.size());
  }

}
