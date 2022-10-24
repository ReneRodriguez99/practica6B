/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

/**
 *
 * @author reney
 */

import java.awt.Color;

//Crea círculos
public class Circles {
    
    private int xPosition;
    private int yPosition;
    private int diameter;
    private Color color;
    private Canvas canvas;
    
    //Metodo constructor que crea un circulo con sus respectivos atributos
    public Circles(int xPos, int yPos, int d, Canvas drawingCanvas,String color)
    {
        diameter = d;
        xPosition = xPos;
        yPosition = yPos;
        canvas = drawingCanvas;
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPos, yPos, diameter);
    }
    
    //redibuja el circulo con un color diferente
     public void cambiarColor(Canvas drawingCanvas,String color)
    {
        canvas = drawingCanvas;
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition,diameter);
    }
    
    
}
