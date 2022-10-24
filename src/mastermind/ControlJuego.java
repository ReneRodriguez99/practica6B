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
import java.util.ArrayList;

//Clase que lleva todo el control logico y interno del juego MASTERMIND
public class ControlJuego{
    
    private Scanner scan;
    private Tablero interfazGrafica;
    //ArrayList de string donde se podra introducir el codigo a descifrar
    private ArrayList <String> codigoPosible;
    private CodigoSecreto codigoSecreto;
    private int espacio = 0;
    private int espacio_clavijas = 0;
    private String codigoEscritoTotal;
    private String codigoSecretoTotal;
    private boolean codigoCorrecto = false;
    private int intentos = 1;
    private ArrayList<String> codigosUsados;
   
    
    public ControlJuego()
    {
        scan = new Scanner(System.in);
        codigoSecreto = new CodigoSecreto();
        codigoSecreto.generarCodigo();
        codigoSecreto.obtenerCodigoSecreto();
        //Se concatenan las partes del codigo Secreto en una sola Cadena para la comparación (lo mismo sucede con el codigo introducido)
        codigoSecretoTotal = codigoSecreto.getCodigoSecreto(0).concat(codigoSecreto.getCodigoSecreto(1)).concat(codigoSecreto.getCodigoSecreto(2)).concat(codigoSecreto.getCodigoSecreto(3))
        .concat(codigoSecreto.getCodigoSecreto(4)).concat(codigoSecreto.getCodigoSecreto(5));
        interfazGrafica = new Tablero();
        interfazGrafica.dibujarTablero(15,6);
        codigoPosible = new ArrayList();
        codigosUsados = new ArrayList();
        codigosUsados.add("");
        
        //Se crea el tamaño del arraylist (6 partes de codigo) concorde al
        //tamaño del codigo
        for(int i = 0; i<6; i++)
        {
            codigoPosible.add("");
        }
    }
    
    
    //Inicia un nuevo juego
    public void iniciarJuego()
    {
        System.out.println("                   MASTERMIND");
        
        //Mientras no se haya descifrado el codigo y no se haya llegado al limite de intentos
        //El juego seguira en curso
        while(intentos<=15 && codigoCorrecto == false)
        {
            //Muestra el codigo Secreto para pruebas
            codigoSecreto.mostrarCodigoSecreto();
            introducirCodigo();
            colocarBolas();
            compararCodigo(codigoSecreto);
            comprobarCodigo();
            
            //Cuando se compruebe que el codigo introducido coincide con el oculto se termina el juego
            //y se declara que se gano el juego
            if(codigoCorrecto)
            {
                //Se Declararía el fin del juego, por lo tanto terminaría el bucle
                System.out.println("\nFELICIDADES, LOGRASTES ADIVINAR EL CODIGO SECRETO!!!");
             
            }
            //En caso en superar el limite de intentos o no poder haber adivinado el codigo secreto
            //Se tomara que se perdio el juego
            else if(intentos == 15)
            {
                interfazGrafica.mostrarCodigoSecreto(codigoSecreto);
                System.out.println("\nNO LOGRASTES ADIVINAR EL CODIGO SECRETO :(");
                System.out.println("Codigo Secreto: ");
                codigoSecreto.mostrarCodigoSecreto();
               
                intentos++;
            }
            else
            {
                //Inicia el siguiente intento
                intentos++;
            }
            
        }
             
    }
    
    
    //para introducir cada parte del codigo
    public void setCodigo(int posicion,String color)
    {
        String codigo;
        codigo = color.toUpperCase();
        codigoPosible.set(posicion,codigo);
    }
  
    //Se introduce los 6 colores del codigo
    public void introducirCodigo()
    {
      boolean colorCorrecto = false;
      boolean codigoRepetido = true;
       int j = 1;
        
       System.out.println("                   Intento " + intentos);
        
      
       while(codigoRepetido)
       {
           
            for(int i = 0; i<6; i++)
            {
                    while(colorCorrecto == false)
                    {
                        System.out.println("Introduzca el color " + j + " del código a adivinar (AZ,RO,VE,AM,BL,NA,MO,RS): ");
                        setCodigo(i,scan.next());
               
                        //Se comprueba que se haya introducido un color correcto, si no se le pide al usuario que lo intente de nuevo
                        if(!"AZ".equals(codigoPosible.get(i)) && !"RO".equals(codigoPosible.get(i)) && !"VE".equals(codigoPosible.get(i))
                        && !"AM".equals(codigoPosible.get(i)) && !"NA".equals(codigoPosible.get(i)) && !"BL".equals(codigoPosible.get(i))
                        && !"MO".equals(codigoPosible.get(i)) && !"RS".equals(codigoPosible.get(i)))
                        {
                            System.out.println("Color no disponible, introduzca un color existente");
                        }
                        else
                        {
                            colorCorrecto = true;
                            j++;
                        }
                
                    }
                    colorCorrecto = false;
            }
        
            //Igual que con el codigo secreto, el codigo introducido se concatena sus partes para compararlo con el código secreto
            codigoEscritoTotal = codigoPosible.get(0).concat(codigoPosible.get(1)).concat(codigoPosible.get(2)).concat(codigoPosible.get(3)).concat(codigoPosible.get(4)).concat(codigoPosible.get(5));
      
            
            //si el codigo actual coincide con la lista de codigos usados, se le pedira al usuario
            //que introduzca una combinacion diferente.
            boolean repetido = false;
            for(int i = 0; i<codigosUsados.size();i++)
            {
                
                if(codigoEscritoTotal.equals(codigosUsados.get(i)))
                {
                   System.out.println("\nCódigo introducido anteriormente, intente con otro código\n");
                   repetido = true;
                   j = 1;
                   
                }
            }
            
            
            if(repetido!=true)
            {
                codigoRepetido = false;
            }
            
            
            
       }
       
       //los codigos introducidos se guardaran en un arraylist 
       //para que el jugador no los pueda volver a utilizar.
       codigosUsados.add(codigoEscritoTotal);
      
        
       
    }
    
    //concorde al color introducido, la bola se dibujara del color seleccionado en el tablero
   public void colocarBolas()
   {
       
       for(int i = 0; i<codigoPosible.size();i++)
       {
            switch(codigoPosible.get(i))
            {
               //Se colocan las clavijas o bolas dependiendo que color fue introducido
                case "RO":
                    interfazGrafica.ponerBola(espacio,"red");
                break;
                
                case "AZ":
                    interfazGrafica.ponerBola(espacio,"blue");
                break;
               
                case "AM":
                   interfazGrafica.ponerBola(espacio,"yellow");
                break;
               
                case "VE":
                   interfazGrafica.ponerBola(espacio,"green");
                break;
               
                case "NA":
                   interfazGrafica.ponerBola(espacio,"orange");
                break;
               
                case "BL":
                   interfazGrafica.ponerBola(espacio,"white");
                break;
                case "MO":
                   interfazGrafica.ponerBola(espacio,"purple");
                break;
                
                case "RS":
                   interfazGrafica.ponerBola(espacio,"pink");
                break;


               default:
               
               
            }
            espacio++;
        }
       
            
    }

    //Compara cada parte del codigo con el codigo secreto
   public void compararCodigo(CodigoSecreto codigoSecreto)
   {
       //Si el primer color del codigo es igual al primer color del codigo secreto significa
       //que el color introducido forma parte del codigo secreto y se encuentra en su posición correcta.
       if(codigoPosible.get(0).equals(codigoSecreto.getCodigoSecreto(0)))
       { 
           //Se coloca una clavija roja para indicar que el color forma parte del codigo secreto
           //y se encuentra en su posición correcta
           interfazGrafica.ponerClavija(espacio_clavijas,"red");
           espacio_clavijas++;
          
       }
       //Si el primer es igual a unos de los colores del color secreto expecto el color secreto de su posicion
       //Significa que el color pertenece al codigo secreto pero no esta en su posición correcta
       else if(codigoPosible.get(0).equals(codigoSecreto.getCodigoSecreto(1)) || codigoPosible.get(0).equals(codigoSecreto.getCodigoSecreto(2)) || codigoPosible.get(0).equals(codigoSecreto.getCodigoSecreto(3))
        || codigoPosible.get(0).equals(codigoSecreto.getCodigoSecreto(4)) || codigoPosible.get(0).equals(codigoSecreto.getCodigoSecreto(5)))
       {
           //Se coloca una clavija blanca para indicar que el color pertenece al codigo secreto
           //pero no se encuentra en su posicion correcta
           interfazGrafica.ponerClavija(espacio_clavijas,"white");
           espacio_clavijas++;
           
       }
       else
       {
           //Entonces el color no forma parte del codigo secreto
           espacio_clavijas++;
           
       }
       
       //si el color de la segunda posicion es igual al primer color, significa que se introdujo
       //un color repetido por lo tanto no se marca una clavija roja o blanca.
       if(!codigoPosible.get(1).equals(codigoPosible.get(0))){
            if(codigoPosible.get(1).equals(codigoSecreto.getCodigoSecreto(1)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"red");
                espacio_clavijas++;
               
            }
            else if(codigoPosible.get(1).equals(codigoSecreto.getCodigoSecreto(0)) || codigoPosible.get(1).equals(codigoSecreto.getCodigoSecreto(2)) || codigoPosible.get(1).equals(codigoSecreto.getCodigoSecreto(3))
                    || codigoPosible.get(1).equals(codigoSecreto.getCodigoSecreto(4)) || codigoPosible.get(1).equals(codigoSecreto.getCodigoSecreto(5)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"white");
                espacio_clavijas++;
                
            }
            else
            {
                //Entonces el color no forma parte del codigo secreto
                espacio_clavijas++;
            }
        }
        else
        {
            //de lo contrario, se sigue al siguiente espacio de clavija roja o blanca
            espacio_clavijas++;
        }
       
       //Lo mismo sería con el tercer color pero ahora comparando con los anteriores colores
       //introducidos para verificar si se introdujo un color repetido
       if(!codigoPosible.get(2).equals(codigoPosible.get(0)) && !codigoPosible.get(2).equals(codigoPosible.get(1)))
       {
            if(codigoPosible.get(2).equals(codigoSecreto.getCodigoSecreto(2)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"red");
                espacio_clavijas++;
                
            }
            else if(codigoPosible.get(2).equals(codigoSecreto.getCodigoSecreto(0)) || codigoPosible.get(2).equals(codigoSecreto.getCodigoSecreto(1)) || codigoPosible.get(2).equals(codigoSecreto.getCodigoSecreto(3))
                    || codigoPosible.get(2).equals(codigoSecreto.getCodigoSecreto(4))  || codigoPosible.get(2).equals(codigoSecreto.getCodigoSecreto(5)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"white");
                espacio_clavijas++;
               
            }
            else
            {
                espacio_clavijas++;
           
            }
       
       }
       else
       {
           espacio_clavijas++;
       }
       
       
       
       //Lo mismo sería con el cuarto color
       if(!codigoPosible.get(3).equals(codigoPosible.get(0)) && !codigoPosible.get(3).equals(codigoPosible.get(1)) && !codigoPosible.get(3).equals(codigoPosible.get(2)))
       {    
           if(codigoPosible.get(3).equals(codigoSecreto.getCodigoSecreto(3)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"red");
                espacio_clavijas++;
                
           
            }
            else if(codigoPosible.get(3).equals(codigoSecreto.getCodigoSecreto(1)) || codigoPosible.get(3).equals(codigoSecreto.getCodigoSecreto(2)) || codigoPosible.get(3).equals(codigoSecreto.getCodigoSecreto(0))
                    || codigoPosible.get(3).equals(codigoSecreto.getCodigoSecreto(4)) || codigoPosible.get(3).equals(codigoSecreto.getCodigoSecreto(5)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"white");
                espacio_clavijas++;
                
            }
            else
            {
                espacio_clavijas++;
            }
       }
       else
       {
           
           espacio_clavijas++;
       }
       
       
       
       //Quinto color
       if(!codigoPosible.get(4).equals(codigoPosible.get(0)) && !codigoPosible.get(4).equals(codigoPosible.get(1)) && !codigoPosible.get(4).equals(codigoPosible.get(2))
               && !codigoPosible.get(4).equals(codigoPosible.get(3)))
       {    
           if(codigoPosible.get(4).equals(codigoSecreto.getCodigoSecreto(4)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"red");
                espacio_clavijas++;
                
           
            }
            else if(codigoPosible.get(4).equals(codigoSecreto.getCodigoSecreto(0)) || codigoPosible.get(4).equals(codigoSecreto.getCodigoSecreto(1)) || codigoPosible.get(4).equals(codigoSecreto.getCodigoSecreto(2))
                    || codigoPosible.get(4).equals(codigoSecreto.getCodigoSecreto(3)) || codigoPosible.get(4).equals(codigoSecreto.getCodigoSecreto(5)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"white");
                espacio_clavijas++;
                
            }
            else
            {
                espacio_clavijas++;
            }
       }
       else
       {
           
           espacio_clavijas++;
       }
       
       
       
       
       //Sexto color
       if(!codigoPosible.get(5).equals(codigoPosible.get(0)) && !codigoPosible.get(5).equals(codigoPosible.get(1)) && !codigoPosible.get(5).equals(codigoPosible.get(2))
               && !codigoPosible.get(5).equals(codigoPosible.get(3)) && !codigoPosible.get(5).equals(codigoPosible.get(4)))
       {    
           if(codigoPosible.get(4).equals(codigoSecreto.getCodigoSecreto(4)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"red");
                espacio_clavijas++;
                
            }
            else if(codigoPosible.get(5).equals(codigoSecreto.getCodigoSecreto(0)) || codigoPosible.get(5).equals(codigoSecreto.getCodigoSecreto(1)) || codigoPosible.get(5).equals(codigoSecreto.getCodigoSecreto(2))
                    || codigoPosible.get(5).equals(codigoSecreto.getCodigoSecreto(3)) || codigoPosible.get(5).equals(codigoSecreto.getCodigoSecreto(4)))
            {
                interfazGrafica.ponerClavija(espacio_clavijas,"white");
                espacio_clavijas++;
                
            }
            else
            {
                espacio_clavijas++;
            }
       }
       else
       {
           
           espacio_clavijas++;
       }
       
       
   }
   
  
   //Se comprueba si ambos codigos coinciden
   public boolean comprobarCodigo()
   {
       //Si coindicen se considerara que se ganó el juego y regresa un valor booleano
       if(codigoEscritoTotal.equals(codigoSecretoTotal))
       {
           codigoCorrecto = true;
       }
       else
       {
           //En caso contrario el codigo introducido se vacía para 
           //introducir un nuevo codigo
           codigoEscritoTotal = "";
       }
       
       //si regresa un true significaría el fin del juego
       return codigoCorrecto;
   }
   
   
   
}

 
 
    
