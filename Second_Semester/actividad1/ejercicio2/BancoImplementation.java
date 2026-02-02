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
        La clase "Titular" tiene el propósito de integrar la 
        noción del titular de una cuenta bancaria, es decir, 
        persona responsable y dueña del dinero o las deudas
        atadas a una cuenta bancaria cualquiera.  
  * @version      
        17.0.6 06 Jan 2023   @author          
        Jorge Celis  */
class Titular{
 
    /**  
    Número de identificación de la persona (titular) (ID).*/
    private int id;
         
    /**  
    Nombre del titular.*/
    private String nombre;
 
    /**
     *  Permite inicializar (set) el nombre y la
        identificación del titular.     
        @param nombre cadena para determinar el nombre.
        @param id integro para determinar la ID.
        @return void. */
    public Titular(String nombre, int id){
        this.nombre=nombre;
        this.id=id;
    }
 
    /**
     * Devuelve el nombre del titular.
        @return String*/
    public String getNombre(){
    return nombre;
    }
 
    /**
     * Devuelve la identificación del titular.
        @return String*/
    public int getId(){
    return id;
    }
 
    @Override
    public String toString(){
    return "\n\tTitular: "+nombre+"\n\tID: "+id;
    }
}

/**
 *   
    En la clase "CuentaAhorro" se implementan los comportamientos y  
    atributos de una cuenta corriente.
    <li> Note: para los propósitos de este ejercicio, el interés 
    se calcula y acumula sobre el 3% del saldo.  
 * @version      
    17.0.6 06 Jan 2023   @author          
    Jorge Celis  */
class CuentaAhorro{
 
    /**  
     Titular de la cuenta.*/
    private Titular titular;
 
    /**  
     Número de la cuenta (un titular puede tener varias cuentas).*/
    private int numero;
 
    /**  
     Una llave especial que en teoría solo debe utilizar el banco si
     quiere saber acerca del titular de una cuenta específica.*/
    private String key;
 
    /**  
     Única clave que debiese conocer el usuario para acceder al dinero 
     de su cuenta.*/
    private String password;
 
    /**  
     El saldo de la cuenta (default 0).*/
    private double saldo;
 
    /**
      * Permite inicializar (set) los atributos de la 
        cuenta.
        @param titular a quién le pertenece la cuenta.
        @param numero integro para determinar el numero de cuenta.
        @param password cadena para determinar el password.
        @param key cadena para determinar la llave. 
        @param saldo el saldo inicial de la cuenta.
        @return void. */
    public CuentaAhorro(Titular titular, int numero, String password, String key, double saldo){
        this.titular=titular;
        this.numero=numero;
        this.password=password;
        this.key=key;
        if (saldo<0) {
            System.out.println("No se puede insertar un saldo inicial negativo!");
        } else this.saldo=saldo;
    }
 
    /**
      * Retorna el saldo de la cuenta. 
        @return un float double, que es el saldo. */
    public double getSaldo(){
        return saldo;
    }
 
    /**
     * Con el fin de implementar el elemento {@code key}, este
        método es utilizado, en teoría, solo por el banco para que pueda 
        conocer el titular, numero de cuenta, y tipo de cuenta en cuestión 
        según lo requiera la situación. 
        @param key 
        @return una cadena que muestra al titular de la cuenta, el 
        numero y tipo de esta.*/
    public String getAccountInfo(String key){
        if (this.key.equals(key)) return "\n\tNúmero de cuenta: "+numero+titular
        +"\n\tTipo: cuenta de ahorros";
        else return null;
    }
 
    /**
     * Permite al usuario retirar dinero de su cuenta, y para ello necesita:
        @param egreso la cantidad que va a retirar.
        @param nombre su nombre.
        @param id su identificación
        @param numero el número de la cuenta
        @param password la clave antes descrita. 
        @return void. */
    public void retirar(double egreso, String nombre, int id, int numero, String password){
        if (!titular.getNombre().equals(nombre)
        ||titular.getId()!=id
        ||this.numero!=numero
        ||!this.password.equals(password)){
            System.out.println("El titular, numero de cuenta, o password no coinciden!");
            return;
        } 
        if (egreso<0) {
            System.out.println("No se pueden retirar numeros negativos!");
            return;
        } 
        if (egreso>saldo){
            System.out.println("No se pueden hacer sobregiros en cuenta de ahorros!");
            return;
        }
        saldo-=egreso;
    }
 
    /**
     * Permite al usuario, o cualquier otro, depositar dinero en la cuenta.
    Para ello se necesita:    
        @param ingreso la cantidad que se va a depostiar. 
        @param nombre el nombre del titular de la cuenta.
        @param id el ID del titular de la cuenta.
        @param numero el número de la cuenta.
        @return void. */
    public void depositar(double ingreso, String nombre, int id, int numero){
        if (!titular.getNombre().equals(nombre)
        ||titular.getId()!=id
        ||this.numero!=numero
        ||!this.password.equals(password)){
            System.out.println("El titular, numero de cuenta, o password no coinciden!");
            return;
        } 
        if (ingreso<0) {
            System.out.println("No se pueden depositar numeros negativos!");
            return;
        }
        saldo+=ingreso+saldo*1.03;
    }
}
 
/**
 *  
        En la clase "CuentaCorriente" se implementan los comportamientos 
        de una cuenta corriente.
        <li> Note: para los propósitos de este ejercicio, se pueden hacer
        sobregiros hasta un máximo establecido por el elemento 
        {@code sobregiro}.
 * @version      
    17.0.6 06 Jan 2023   @author          
    Jorge Celis  */
 class CuentaCorriente{

    /**  
     El máximo sobregiro que se puede hacer (default 0).*/
     private double sobregiro;

    /**  
     Titular de la cuenta.*/
     private Titular titular;
 
    /**  
     Número de la cuenta (un titular puede tener varias cuentas).*/
     private int numero;
 
    /**  
     Una llave especial que en teoría solo debe utilizar el banco si
     quiere saber acerca del titular de una cuenta específica.*/
     private String key;
 
    /**  
     Única clave que debiese conocer el usuario para acceder al dinero 
     de su cuenta.*/
     private String password;
 
    /**  
     El saldo de la cuenta (default 0).*/
     private double saldo;

    public CuentaCorriente(Titular titular, int numero, String password, String key, double saldo){
        this.titular=titular;
        this.numero=numero;
        this.password=password;
        this.key=key;
        if (saldo<0) {
            System.out.println("No se puede insertar un saldo inicial negativo!");
        } else this.saldo=saldo;
    }

    /**
     * Inicializa (set) el sobregiro de la cuenta.
        @param sobregiro cantidad para establecer el máximo de sobregiro.
        @return void. */
    public void setSobregiro(double sobregiro){
        if (sobregiro<0) System.out.print("No se pueden establecer sobregiros negativos");
        else this.sobregiro=sobregiro;
    }

    /**
     * Retorna el sobregiro establecido.
        @return un float double positivo, que es el sobregiro. */
    public double getSobregiro(){
        return sobregiro;
    }

    /**
     * Retorna el saldo de la cuenta. 
        @return un float double, que es el saldo. */
    public double getSaldo(){
        return saldo; 
    }
    
    /**
     * Con el fin de implementar el elemento {@code key}, este
        método es utilizado, en teoría, solo por el banco para que pueda 
        conocer el titular, numero de cuenta, y tipo de cuenta en cuestión 
        según lo requiera la situación. 
        @param key 
        @return una cadena que muestra al titular de la cuenta, el 
        numero y tipo de esta.*/
    public String getAccountInfo(String key){
        if (this.key.equals(key)) return "\n\tNúmero de cuenta: "+numero+titular
        +"\n\tTipo: cuenta de ahorros";
        else return null;
    }

    /**
      * Permite al usuario retirar dinero de su cuenta, y para ello necesita:
         @param egreso la cantidad que va a retirar.
         @param nombre su nombre.
         @param id su identificación
         @param numero el número de la cuenta
         @param password la clave antes descrita. 
         @return void. */
    public void retirar(double egreso, String nombre, int id, int numero, String password) {
        if (!titular.getNombre().equals(nombre)
        ||titular.getId()!=id
        ||this.numero!=numero
        ||!this.password.equals(password)){
            System.out.println("El titular, numero de cuenta, o password no coinciden!");
            return;
        } 
        if (egreso<0) {
            System.out.println("No se pueden retirar numeros negativos!");
            return;
        } 
        if ((saldo-egreso)<-sobregiro){
            System.out.println("Máximo de sobregiro alcanzado!");
            return;
        }
        saldo-=egreso;
    }

    /**
      * Permite al usuario, o cualquier otro, depositar dinero en la cuenta.
      Para ello se necesita:    
         @param ingreso la cantidad que se va a depostiar. 
         @param nombre el nombre del titular de la cuenta.
         @param id el ID del titular de la cuenta.
         @param numero el número de la cuenta.
         @return void. */
    public void depositar(double ingreso, String nombre, int id, int numero) {
        if (!titular.getNombre().equals(nombre)
        ||titular.getId()!=id
        ||this.numero!=numero
        ||!this.password.equals(password)){
            System.out.println("El titular, numero de cuenta, o password no coinciden!");
            return;
        } 
        if (ingreso<0) {
            System.out.println("No se pueden depositar numeros negativos!");
            return;
        }
        saldo+=ingreso;
    }
}
