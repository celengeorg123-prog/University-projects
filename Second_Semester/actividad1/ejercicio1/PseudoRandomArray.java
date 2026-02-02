/*
 * @(#)PseudoRandomArray.java  17.0.6 06/02/2023      
 * 
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package ejercicio1;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 
        PseudoRandomArray tiene las siguientes tareas: 
        <li>1. Poseer la función principal main;
        <li>2. Establecer un arreglo de tamaño arbitrario inicializado con
        valores enteros pertenecientes a [10,300];
        <li>3. Determinar, según el arreglo y la unidad, qué elementos 
        del arreglo poseen como último digito la unidad seleccionada.
 * @version      
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class PseudoRandomArray{

    /**  
        Arreglo de integros que servirá como base en el programa. */
    private Integer[] baseArray;

    /**  
        Contenedor que obtendra los elementos deseados sin repetición. */
    private Set<Integer> conjunto=new HashSet<Integer>();

    /**
     * Determina el tamaño e inicializa a baseArray.      
        @param n  Integro para determinar el tamaño.
        @return void. */
    public void setBaseArraySize(Integer n){
        baseArray=new Integer[n];
        for (int i=0; i<baseArray.length;i++){
            baseArray[i]=(int)(Math.random()*(291)+10);
        }
    }

    /**
     * Retorna baseArray. 
       @return baseArray*/
    public Integer[] getBaseArray(){
        return baseArray;
    }

    /**
     *  Construye y retorna el arreglo con los numeros cuyo 
        último digito es igual a n; sin repeticiones.
          @param x Arreglo de input;      
          @param n Integro determinante del último digito;
          @return  un arreglo con todos los digitos cuyo último
          digito es igual a n*/ 
    public Integer[] setConjunto(Integer[] x, int n){
        for (int s:x) if(s%10==n) conjunto.add(s);
        return conjunto.toArray(new Integer[0]);
    }

    /**
     *
        Función main, donde se implementan las funcionalidades
        solicitadas en el ejercicio: 
        <li> 1. Declaramos dos variables de tipo integro, {@code numero1Usuario} y
        {@code numero2Usuario}, para recibir input de los usuarios;
        <li> 2. Una instancia de {@code Sample} de PseudoRandomArray;
        <li> 3. Una instancia {@code Reader} de Scanner para leer integros;
        @param args
        @return void
    */
    public static void main(String[] args){
        int numero1Usuario,numero2Usuario;//Input del usuario
        PseudoRandomArray Sample=new PseudoRandomArray();
        Scanner Reader;//Se va ha utilizar Scanner para leer input del usuario
        do{
            Reader=new Scanner(System.in);
            try{
                System.out.print("Enter a nonnegative integer: ");
                while((numero1Usuario=Reader.nextInt())<0) System.out.print("Please, " 
                +"enter a nonnegative number: ");
                Sample.setBaseArraySize(numero1Usuario);
                System.out.println("Then we have an array of "+numero1Usuario
                +" elements which are integers between 10 and 300.");
                break;
            }catch(InputMismatchException e){//En caso que se de input invalido
                System.out.println("Wrong input!\nTry again.");
            }
        }while(true);
        do{
            Reader=new Scanner(System.in);
            try{
                System.out.print("Now, enter a nonnegative integer lesser than 10: ");
                numero2Usuario=Reader.nextInt();
                while(numero2Usuario<0||numero2Usuario>=10){
                    System.out.print("Please, enter a nonnegative integer lesser than 10: ");
                    numero2Usuario=Reader.nextInt();
                }
                /*
                *Arreglo que contiene todos los integros cuyo último 
                 digito es igual a numero2Usuario.
                */
                var holder=Sample.setConjunto(Sample.getBaseArray(), numero2Usuario);
                System.out.println("Then, from our pseudo random array, we have that: ");
                if (holder.length==0) System.out.println("There is no elements with"
                +" final digit equal to " +numero2Usuario+'.');
                else{
                    for (var h:holder){
                        System.out.println(h);
                    }
                    System.out.println("is/are the element(s) with final digit equal to "
                    +numero2Usuario+'.');
                }   
                Integer sumAcumulador=0;//Acumulador suma de todos los elementos de holder
                for (var n2:holder){
                    sumAcumulador+=n2;
                }
                System.out.println("Also, this is the sum of such number(s) "+
                "(default is zero): "+sumAcumulador);
                break;
            }catch(InputMismatchException e){
                System.out.println("Wrong input!\nTry again.");
            }
        }while(true);
        Reader.close();
    }
}

  