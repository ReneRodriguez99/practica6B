/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author reney
 */

//Clase que genera un codigo aleatorio sin repetir usando HashMap
public class CodigoSecreto {
    
    private HashMap<Integer,String> codigo;
    private ArrayList <String> codigoLista;
    
    public CodigoSecreto()
    {
       codigo = new HashMap<Integer,String>();
   
    }
    
    //Metodo principal que generara el codigo
    public void generarCodigo()
    {
        //Indica que en la primera iteracion se esta generando el primer color del codigo
        boolean primerColor = true;
        boolean repetido;
        int numR = 1;
        String color;
        Random r = new Random();
        
        
        for(int i=0;i<6;i++)
        {
            repetido = true;
            while(repetido == true)
            {
                numR = r.nextInt(8) + 1;
                switch(numR)
                {
                    case 1:
                        /*
                        Nunca se cumpliria esta condicion en la primera iteracion
                        Si se vuelve a cumplir este caso que anteriormente ya se habia
                        cumplido indicara que el color esta repetido dentro de la coleccion,
                        por lo tanto el ciclo while se ejecutara todas las veces hasta que se genere
                        un color que no esta dentro en la coleccion HashMap.
                        */
                        if(codigo.containsValue("AZ") && primerColor == false)
                        {
                            repetido = true;
                        }
                        else
                        {
                            color = "AZ";
                            codigo.put(1,"AZ");
                            //indica que el color que se genero no esta repetido dentro de la coleccion HashMap
                            repetido = false;
                        }
                    break;
                
                    case 2:
                        if(codigo.containsValue("RO") && primerColor ==  false)
                        {
                            repetido = true;
                        }
                        else
                        {
                            color = "RO";
                            codigo.put(2,"RO");
                            repetido = false;
                        }
                    break;
                
                    case 3:
                        if(codigo.containsValue("VE") && primerColor ==  false)
                        {
                            repetido = true;
                        }
                        else
                        {
                            color = "VE";
                            codigo.put(3,"VE");
                            repetido = false;
                        }
                    break;
                
                    case 4:
                        if(codigo.containsValue("AM") && primerColor ==  false)
                        {
                            repetido = true;
                        }
                        else
                        {
                            color = "AM";
                            codigo.put(4,"AM");
                            repetido = false;
                        }
                    break;
                
                    case 5:
                        if(codigo.containsValue("NA") && primerColor ==  false)
                        {
                            repetido = true;
                        }
                        else
                        {
                            color = "NA";
                            codigo.put(5,"NA");
                            repetido = false;
                        }
                    break;
                
                    
                    case 6:
                        if(codigo.containsValue("BL") && primerColor ==  false)
                        {
                            repetido = true;
                        }
                        else
                        {
                            color = "BL";
                            codigo.put(6,"BL");
                            repetido = false;
                        }
                    break;
                    
                    
                    case 7:
                        if(codigo.containsValue("MO") && primerColor ==  false)
                        {
                            repetido = true;
                        }
                        else
                        {
                            color = "MO";
                            codigo.put(7,"MO");
                            repetido = false;
                        }
                    break;
                    
                    
                    case 8:
                        if(codigo.containsValue("RS") && primerColor ==  false)
                        {
                            repetido = true;
                        }
                        else
                        {
                            color = "RS";
                            codigo.put(8,"RS");
                            repetido = false;
                        }
                    break;
                
                    default:
                }
            }
            /*
            Al finalizar la primera iteracion, la bandera que indicaba que se esta generando
            el primer color del codigo es falsa ya que se estaria generando en la siguiente
            iteracion el segundo color
            */
            primerColor = false;
        }
        
    }
    
    
   public void mostrarCodigoSecreto()
   {
        System.out.println(codigoLista);
   }
    
    
    //Se crea un ArrayList que copia los elementos de la coleccion Hashmap para las comparaciones
    //con el codigo introducido por el usuario
    public void obtenerCodigoSecreto()
    {
        codigoLista = new ArrayList();
        for(int i = 1;i<=8;i++)
        {     
            if(codigo.get(i) != null)
            {
                codigoLista.add(codigo.get(i));
            }
        }
        
    }
    
   
    //Regresa un color del codigo con posicion seleccionada
    public String getCodigoSecreto(int posicion)
    {
        return codigoLista.get(posicion);
    }
    
}
