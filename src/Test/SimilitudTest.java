package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Similitud;

public class SimilitudTest {
  
  Similitud s;
  String[] t1 = {"hola", "como", "estas", "mi", "amigo"};
  String[] t2 = {"hola", "que", "tal", "mate"};
  
  @Before
  public void settings(){
    s = new Similitud();
  }
  
  @Test
  public void similtudTest(){
    double i = s.similitud(t1, t1);
    assertEquals("la similitu debe ser 1", 1, i, 0.003);
  }
  
  @Test
  public void similitudTest2(){
    double i = s.similitud(t1, t2);
    assertEquals("la similitu debe ser 0.222", 0.22222, i, 0.3);
  }
}
