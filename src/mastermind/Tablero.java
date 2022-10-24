/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

import java.util.ArrayList;

/**
 *
 * @author reney
 */
//Clase que muestra la interfaz o la parte grafica del juego MASTERMIND
public class Tablero {
    
    private Canvas myCanvas;
    private Rectangles tabla;
    //ArrayList de las clavijas o bolas de color que utilizaremos para descifrar el codigo
    private  ArrayList <Circles> bola_color;
    //Las clavijas en blanco y rojo para retroalimentacion
    private ArrayList <Circles> clavijas;
    //Representan en el tablero los colores que estaran disponibles para el codigo
    private ArrayList <Circles> colores;
    //Si el jugador no pudo descifrar el codigo secreto, se mostrara en el tablero cual
    //era la combinacion de colores
    private ArrayList <Circles> codigo_secreto;
    
    public Tablero(){
        
        bola_color = new ArrayList();
        clavijas = new ArrayList();
        colores = new ArrayList();
        codigo_secreto = new ArrayList();
        
    }
    
    public void dibujarTablero(int intentos,int fila_bola)
    {
        myCanvas = new Canvas("MASTERMIND", 640, 800);
        dibujarTitulo();
        tabla = new Rectangles(130,85,375,700,myCanvas,"brown");
        
        //Creacion de los espacios de las clavijas y bolas
        int x_bolas = 150;
        int y_bolas = 705;
        int x_clavija = 365;
        int y_clavija = 722;
  
        for (int j=0; j<intentos;j++)
        {
            for(int i=0;i<fila_bola;i++)
            {
                bola_color.add(new Circles(x_bolas,y_bolas,25,myCanvas,"black"));
                x_bolas+=35;
            }
            y_bolas-=40;
            x_bolas=150;
        }
        
        for (int z = 0;z<intentos;z++)
        {
            for (int j=0; j<2;j++)
            {
                for(int i=0;i<3;i++)
                {
                    clavijas.add(new Circles(x_clavija,y_clavija,8,myCanvas,"black"));
                    x_clavija+=13;
                }
   
                y_clavija-=16;
                x_clavija=365;
            }
            y_clavija-=8;
        }
        
        dibujarSimbologia();
    }
    
    //Con este metodo se podra colocar el codigo en la tabla
    public void ponerBola(int posicion,String color)
    {
        bola_color.get(posicion).cambiarColor(myCanvas,color);
    }
    
    //coloca una clavija de retroalimentacion ya sea blanca o roja
    public void ponerClavija(int posicion,String color)
    {
        clavijas.get(posicion).cambiarColor(myCanvas,color);
    }
    
    //Dibuja el titulo del juego en la interfaz grafica
    public void dibujarTitulo()
    {
        myCanvas.drawString("MASTERMIND", 175, 70, 40);
    }
    
    //Muestra la simbologia de la tabla; los colores disponibles y su respectiva
    //abreviacion para introducirlos en la consola para descifrar el codigo.
    public void dibujarSimbologia()
    {
        colores.add(new Circles(420,120,30,myCanvas,"red"));
        colores.add(new Circles(420,200,30,myCanvas,"blue"));
        colores.add(new Circles(420,280,30,myCanvas,"yellow"));
        colores.add(new Circles(420,360,30,myCanvas,"green"));
        colores.add(new Circles(420,440,30,myCanvas,"orange"));
        colores.add(new Circles(420,520,30,myCanvas,"white"));
        colores.add(new Circles(420,600,30,myCanvas,"purple"));
        colores.add(new Circles(420,680,30,myCanvas,"pink"));
        myCanvas.drawString("RO", 415, 180, 30);
        myCanvas.drawString("AZ", 415, 260, 30);
        myCanvas.drawString("AM", 415, 340, 30);
        myCanvas.drawString("VE", 415, 420, 30);
        myCanvas.drawString("NA", 415, 500, 30);
        myCanvas.drawString("BL", 415, 580, 30);
        myCanvas.drawString("MO", 415, 660, 30);
        myCanvas.drawString("RS", 415, 740, 30);
    }
    
    //Si el jugador no descifra el codigo secreto, se muestra la combinación del código secreto
    public void mostrarCodigoSecreto(CodigoSecreto codigoGrafico)
    {
        int fila_bola = 6;
        int x_bolas = 150;
        int y_bolas = 105;
        for(int i=0;i<fila_bola;i++)
        {
            switch(codigoGrafico.getCodigoSecreto(i))
            {
                case "RO":
                    bola_color.add(new Circles(x_bolas,y_bolas,25,myCanvas,"red"));
                    x_bolas+=35;
                    
                break;
                
                case "AZ":
                     bola_color.add(new Circles(x_bolas,y_bolas,25,myCanvas,"blue"));
                     x_bolas+=35;
                    
                break;
               
                case "AM":
                     bola_color.add(new Circles(x_bolas,y_bolas,25,myCanvas,"yellow"));
                     x_bolas+=35;
                  
                break;
               
                case "VE":
                     bola_color.add(new Circles(x_bolas,y_bolas,25,myCanvas,"green"));
                     x_bolas+=35;
                  
                break;
               
                case "NA":
                     bola_color.add(new Circles(x_bolas,y_bolas,25,myCanvas,"orange"));
                     x_bolas+=35;
                   
                break;
               
                case "BL":
                     bola_color.add(new Circles(x_bolas,y_bolas,25,myCanvas,"white"));
                     x_bolas+=35;
                  
                break;
                 case "MO":
                     bola_color.add(new Circles(x_bolas,y_bolas,25,myCanvas,"purple"));
                     x_bolas+=35;
                  
                break;
                 case "RS":
                     bola_color.add(new Circles(x_bolas,y_bolas,25,myCanvas,"pink"));
                     x_bolas+=35;
                  
                break;

               default:
                
            }
                
        }
        
    }
    
    
    
}
