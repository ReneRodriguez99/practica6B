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
import java.util.Random;
//Crea Cuadrados o Rectangulos
public class Rectangles{
    
// constants for randomSquiggle method
    private static final int SQIGGLE_SIZE = 40;
    private static final int SQIGGLE_COUNT = 30;
    
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private int rotation;
    private int diameter;
    private Color color;
    private boolean penDown;

    private Canvas canvas;
    private Random random;

   
    //Metodo constructor de dibuja un cuadrado con coordenadas xy ya definidas previamente
    public Rectangles(Canvas drawingCanvas,String color)
    {
        int width = 50;
        int height = 50;
        canvas = drawingCanvas;
        canvas.setForegroundColor(color);
        canvas.fillRectangle(xPosition, yPosition, width, height);
    }

    /**
     * @param xPos  the initial horizontal coordinate of the pen
     * @param yPos  the initial vertical coordinate of the pen
     * @param drawingCanvas  the canvas to draw on
     */
    //Metodo constructor donde se define cada atributo del cuadrado
    public Rectangles(int xPos, int yPos, int w, int h, Canvas drawingCanvas, String color)
    {
        width = w;
        height = h;
        xPosition = xPos;
        yPosition = yPos;
        canvas = drawingCanvas;
        canvas.setForegroundColor(color);
        canvas.fillRectangle(xPos, yPos, width, height);

    }
    
    public void dibujarCirculo(int xPos, int yPos, Canvas drawingCanvas, String color)
    {
        diameter = 50;
        xPosition = xPos;
        yPosition = yPos;
        canvas = drawingCanvas;
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPos, yPos, diameter);
    }
    
    //Se dibuja otro cuadrado pero con diferente color seleccionado
    public void cambiarColor(Canvas drawingCanvas,String color)
    {
        int width = 50;
        int height = 50;
        canvas = drawingCanvas;
        canvas.setForegroundColor(color);
        canvas.fillRectangle(xPosition, yPosition, width, height);
    }
    
    
    public void square()
    {
         for (int i=0; i<4; i++) {
            move(100);
            turn(90);
        }
    }
    
    public void cambiarColor(int xPos, int yPos,String color)
    {   
        int width = 50;
        int height = 50;
        canvas.setForegroundColor(color);
        canvas.fillRectangle(xPos, yPos, width, height);
    }
    
    

    /**
     * Move the specified distance in the current direction. If the pen is down, 
     * leave a line on the canvas.
     * 
     * @param distance  The distance to move forward from the current location.
     */
    public void move(int distance)
    {
        double angle = Math.toRadians(rotation);
        int newX = (int) Math.round(xPosition + Math.cos(angle) * distance);
        int newY = (int) Math.round(yPosition + Math.sin(angle) * distance);
        
        moveTo(newX, newY);
    }

    /**
     * Move to the specified location. If the pen is down, leave a line on the canvas.
     * 
     * @param x   The x-coordinate to move to.
     * @param y   The y-coordinate to move to.
     */
    public void moveTo(int x, int y)
    {
        if (penDown) {
            canvas.setForegroundColor("red");
            canvas.drawLine(xPosition, yPosition, x, y);
        }

        xPosition = x;
        yPosition = y;
    }

    /**
     * Turn the specified amount (out of a 360 degree circle) clockwise from the current 
     * rotation.
     * 
     * @param degrees  The amount of degrees to turn. (360 is a full circle.)
     */
    public void turn(int degrees)
    {
        rotation = rotation + degrees;
    }

    /**
     * Turn to the specified direction. 0 is right, 90 is down, 180 is left, 270 is up.
     * 
     * @param angle  The angle to turn to.
     */
    public void turnTo(int angle)
    {
        rotation = angle;
    }

    /**
     * Set the drawing color.
     * 
     * @param newColor  The color to use for subsequent drawing operations.
     */
    public void setColor(Color newColor)
    {
        color = newColor;
    }

    /**
     * Lift the pen up. Moving afterwards will not leave a line on the canvas.
     */
    public void penUp()
    {
        penDown = false;
    }

    /**
     * Put the pen down. Moving afterwards will leave a line on the canvas.
     */
    public void penDown()
    {
        penDown = true;
    }

    /**
     * Scribble on the canvas in the current color. The size and complexity of the 
     * squiggle produced is defined by the constants SQIGGLE_SIZE and SQIGGLE_COUNT.
     */
    public void randomSquiggle()
    {
        for (int i=0; i<SQIGGLE_COUNT; i++) {
            move(random.nextInt(SQIGGLE_SIZE));
            turn(160 + random.nextInt(40));
        }

    }

    
}
