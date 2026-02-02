/*
 * @(#)AppBanco.java     17.0.6  07/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package ejercicio2;

/**
 * 
        AppBanco es una clase de utilidad cuyo propósito
        es: 
        <li> -Establecer dos instancias de CuentaAhorro;
        <li> -Establecer dos instancias de CuentaCorriente;
        <li> -Contener la función main; 
        <li> -Hacer test de las implementaciones hechas. 
 * @version      
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class AppBanco {
    public static void main(String[] args){//Rutina de prueba
        
        //Declaramos dos titulares.
        Titular persona1=new Titular("Kevin Hass", 3771),
        persona2=new Titular("Alex Moore", 9811);

        //A cada titular le asignamos una cuenta de ahorros con un saldo inicial de $1000.
        CuentaAhorro cuentaAhorro1=new CuentaAhorro(persona1, 731, "C++123", "LP732", 1000),
        cuentaAhorro2= new CuentaAhorro(persona2, 1000231, "Pler563", "Plqw11", 1000);

        //A cada titular le asignamos una cuenta corriente con un saldo inicial de $0
        CuentaCorriente cuentaCorriente1=new CuentaCorriente(persona1, 20091, "Lokw1", "+*1123", 0),
        cuentaCorriente2= new CuentaCorriente(persona2, 981, "Opo761", "Iui1", 0);

        //La cuenta corriente de Kevin puede hacer un máximo de sobregiro de $400.
        cuentaCorriente1.setSobregiro(400);

        //La cuenta corriente de Alex puede hacer un máximo de sobregiro de $200.
        cuentaCorriente2.setSobregiro(200);

        //Hacemos una rutina de retiro y deposito para todas las cuentas.
        cuentaCorriente2.retirar(60,"Alex Moore", 9811, 981, "Opo761");
        cuentaAhorro1.depositar(60, "Kevin Hass", 3771, 731);

        //Esta acción debiese lanzar un mensaje de advertencia por sobrepasar el sobregiro.
        cuentaCorriente1.retirar(800, "Kevin Hass", 3771, 20091, "Lokw1");

        cuentaCorriente1.retirar(200, "Kevin Hass", 3771, 20091, "Lokw1");
        cuentaAhorro2.depositar(900, "Alex Moore", 9811, 1000231);
        cuentaAhorro2.retirar(25, "Alex Moore", 9811, 1000231, "Pler563");
        cuentaCorriente2.depositar(33, "Alex Moore", 9811, 981);

        //Esta acción debiese lanzar un mensaje de advertencia por hacer el sobregiro. 
        cuentaAhorro2.retirar(100000, "Alex Moore", 9811, 1000231, "Pler563");

        //Estas dos acciones debiesen lanzar mensajes de error por no coincidir los datos.
        cuentaCorriente1.depositar(3122,"L",3771,20091);
        cuentaAhorro2.retirar(139009,"Alex Moore", 9811, 1000231, "PPPP");

        //Aquí damos a conocer los saldos resultantes de las cuentas después de la rutina. 
        System.out.println("\nEl saldo de las cuentas de "+persona1.getNombre()+" son:\n"
        +cuentaAhorro1.getAccountInfo("LP732")+"\n\tSaldo: $"+cuentaAhorro1.getSaldo()
        +'\n'+cuentaCorriente1.getAccountInfo("+*1123")+"\n\tSaldo: $"+cuentaCorriente1.getSaldo());
        System.out.println("\nEl saldo de las cuentas de "+persona2.getNombre()+" son:\n"
        +cuentaAhorro2.getAccountInfo("Plqw11")+"\n\tSaldo: $"+cuentaAhorro2.getSaldo()
        +'\n'+cuentaCorriente2.getAccountInfo("Iui1")+"\n\tSaldo: $"+cuentaCorriente2.getSaldo()); 

        //Esto debiese imprimir null. 
        System.out.println("\nPrueba de llaves: "+cuentaAhorro2.getAccountInfo(null));

        //Por úlitmo, determinamos la cuenta corriente con menor saldo...
        System.out.print("\nLa cuenta corriente con menor saldo es: ");
        if (cuentaCorriente1.getSaldo()<cuentaCorriente2.getSaldo()) 
        System.out.println(cuentaCorriente1.getAccountInfo("+*1123"));
        else if(cuentaCorriente1.getSaldo()>cuentaCorriente2.getSaldo())
        System.out.println(cuentaCorriente2.getAccountInfo("Iui1"));
        else System.out.println("Ambas cuentas corrientes poseen el mismo saldo.");

        //...y la cuenta de ahorros con mayor saldo. 
        System.out.print("La cuenta de ahorros con mayor saldo es: ");
        if (cuentaAhorro1.getSaldo()<cuentaAhorro2.getSaldo()) 
        System.out.println(cuentaAhorro2.getAccountInfo("Plqw11"));
        else if (cuentaAhorro1.getSaldo()>cuentaAhorro2.getSaldo())
        System.out.println(cuentaAhorro1.getAccountInfo("LP732"));
        else System.out.println("Ambas cuentas de ahorros poseen el mismo saldo.");
    }
}
