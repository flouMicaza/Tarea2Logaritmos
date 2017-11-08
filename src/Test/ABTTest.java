package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.ABT;
import main.ABTNode;

public class ABTTest {
  
  ABT tree;
  ABT tree2;
  ABTNode centro;
  int contEste=0;
  String[] palabras= {"prologo$","1$","de$","los$","hobbits$","este$","libro$","trata$","principalmente$","de$","los$","hobbits$","y$","el$","lector$","descubrir$","en$","sus$","pginas$","mucho$","del$","carcter$","y$","algo$","de$","la$","historia$","de$","este$","pueblo$","podr$","encontrarse$","ms$","informacin$","en$","los$","extractos$","del$","libro$","rojo$","de$","la$","frontera$","del$","oeste$","que$","ya$","han$","sido$","publicados$","con$","el$","ttulo$","de$","el$","hobbit$","el$","relato$","tuvo$","su$","origen$","en$","los$","primeros$","captulos$","del$","libro$","rojo$","compuesto$","por$","bilbo$","bolsn$","el$","primer$","hobbit$","que$","fue$","famoso$","en$","el$","mundo$","entero$","y$","que$","l$","titul$","historia$","de$","una$","ida$","y$","de$","una$","vuelta$","pues$","contaba$","el$","viaje$","de$","bilbo$","hacia$","el$","este$","y$","la$","vuelta$","aventura$","que$","ms$","tarde$","enredara$","a$","todos$","los$","hobbits$","en$","los$","importantes$","acontecimientos$","que$","aqu$","se$","relatan$","no$","obstante$","muchos$","querrn$","saber$","desde$","un$","principio$","algo$","ms$","de$","este$","pueblo$","notable$","y$","quizs$","algunos$","no$","tengan$","el$","libro$","anterior$","para$","esos$","lectores$","se$","han$","reunido$","aqu$","algunas$","notas$","sobre$","los$","puntos$","ms$","importantes$","de$","la$","tradicin$","hobbit$","y$","se$","recuerda$","brevemente$","la$","primera$","aventura$","los$","hobbits$","son$","un$","pueblo$","sencillo$","y$","muy$","antiguo$","ms$","numeroso$","en$","tiempos$","remotos$","que$","en$","la$","actualidad$","amaban$","la$","paz$","la$","tranquilidad$","y$","el$","cultivo$","de$","la$","buena$","tierra$","y$","no$","haba$","para$","ellos$","paraje$","mejor$","que$","un$","campo$","bien$","aprovechado$","y$","bien$","ordenado$","no$","entienden$","ni$","entendan$","ni$","gustan$","de$","maquinarias$","ms$","complicadas$","que$","una$","fragua$","un$","molino$","de$","agua$","o$","un$","telar$","de$","mano$","aunque$","fueron$","muy$","hbiles$","con$","toda$","clase$","de$","herramientas$","en$","otros$","tiempos$","desconfiaban$","en$","general$","de$","la$","gente$","grande$","como$","nos$","llaman$","y$","ahora$","nos$","eluden$","con$","terror$","y$","es$","difcil$","encontrarlos$","tienen$","el$","odo$","agudo$","y$","la$","mirada$","penetrante$","y$","aunque$","engordan$","fcilmente$","y$","nunca$","se$","apresuran$","si$","no$","es$","necesario$","se$","mueven$","con$","agilidad$","y$","destreza$","dominaron$","desde$","un$","principio$","el$","arte$","de$","desaparecer$","rpido$","y$","en$","silencio$","cuando$","la$","gente$","grande$","con$","la$","que$","no$","queran$","tropezar$","se$","les$","acercaba$","casualmente$","y$","han$","desarrollado$","este$","arte$","hasta$","el$","punto$","de$","que$","a$","los$","hombres$","puede$","parecerles$","verdadera$","magia$","pero$","los$","hobbits$","jams$","han$","estudiado$","magia$","de$","ninguna$","ndole$","y$","esas$","rpidas$","desapariciones$","se$","deben$","nicamente$","a$","una$","habilidad$","profesional$"};
  
  @Before
  public void settings(){
    tree = new ABT("as",1);
    tree2 = new ABT(palabras[0],1);
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
  
  @Test
  public void insertar20Test(){
    for(int i = 0 ; i<25;i++){
      tree2.insertar(palabras[i], 1);
      System.out.println(palabras[i]);
    if(palabras[i]=="este$"){
      contEste++;
    }
  }
    ArrayList<Integer> valores = tree2.busqueda("este$");
    int cont =  valores.size();
    assertNotNull("Debería haberse insertado",valores);
    assertEquals("debería ser el mismo valor que este",contEste,cont);
  }
}
