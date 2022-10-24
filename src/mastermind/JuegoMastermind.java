/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

/**
 *
 * @author reney
 */

import java.util.Scanner;

//Clase que incia el Juego de Mastermind
public class JuegoMastermind{
    
    private Scanner scan;
    private String respuesta = "";
    
    public JuegoMastermind()
    {
        scan = new Scanner(System.in);
        ControlJuego juego = new ControlJuego();
        juego.iniciarJuego();
        
        do
        { 
            System.out.println("¿Desea iniciar un nuevo juego?");
            respuesta = scan.next();
            respuesta = respuesta.toUpperCase();
            
            if(respuesta.equals("SI"))
            {
                juego = new ControlJuego();
                juego.iniciarJuego();
            }
           
            
        }while(respuesta.equals("SI"));
        
        System.out.println("Juego Finalizado");
            
        
    }
    
}
