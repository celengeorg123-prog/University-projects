/*
 * @(#)AppLibro.java     17.0.6  07/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package ejercicio3;

/**
 *   
        La clase autor se usa para simular a la
        persona con facultad de escribir. 
 * @version      
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */ 
class Autor {

    /**  
    Número de identificación del autor. */
    private int id;

    /**  
    Nombre del autor. */
    private String nombre;

    /**  
    País de origen del autor 
    -no necesariamente su nacionalidad-. */
    private String paisOrigen;

    /**
     * Permite inicializar (set) el {@code nombre} del autor.     
        @param nombre cadena para determinar el nombre.
        @return void */
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    /**
     * Permite obtener el {@code nombre} del autor.     
        @return String */
    public String getNombre(){
        return nombre;
    }

    /**
     * Permite inicializar (set) el {@code id} del autor. 
        @param id integro para determinar la identificación.  
        @return void */
    public void setId(int id){
        this.id=id;
    }

    /**
     * Permite obtener el {@code id} del autor. 
        @return int */
    public int getId(){
        return id;
    }
    
    /**
     * Método para inicializar el elemento {@code paisOrigen}.     
        @param paisOrgine cadena para determinar el pais de origen.
        @return void. */
    public void setPaisOrigen(String paisOrigen){
        this.paisOrigen=paisOrigen;
    }

    /**
     * Método para obtener el elemento {@code paisOrigen}.     
        @return String */
    public String getPaisOrigen(){
        return paisOrigen;
    }

    @Override
    public String toString(){
        return "\n\tNombre: "+nombre+"\n\tId: "+id+"\n\tPais de origen: "+paisOrigen;
    }
}

/**
 * 
        Esta clase posee el propósito de 
        abstraer y simular una editorial
        arbitraria.
 * @version      
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
class Editorial{

    /**  
        Código de la editorial. */
    private int codigoEd;

    /**  
        Año de creación de la editorial. */
    private int anoCreacion;

    /**  
        Nombre de la editorial. */
    private String nombreEd;

    /**
     * Método para inicializar (set) el elemento {@code codigoEd}.     
        @param codigo integro para determinar el código de la
        editorial.
        @return void. */
    public void setCodigoEd(int codigo){
        this.codigoEd=codigo;
    }

    /**
     * Método para obtener el elemento {@code codigoEd}.     
        @return int */
    public int getCodigoEd(){
        return codigoEd;
    }

    /**
     *  Método para inicializar (set) el elemento {@code anoCreacion}.  
        @param anoCreacion integro para determinar el año de creación.
        @return void */
    public void setAnoCreacion(int anoCreacion){
        this.anoCreacion=anoCreacion;
    }

    /**
     * Método para obtener el elemento {@code anoCreacion}.     
        @return int */ 
    public int getAnoCreacion(){
        return anoCreacion;
    }

    /**
     * Método para inicialar (set) el elemento {@code nombreEd}.
        @param nombre cadena para determinar el nombre.      
        @return void*/ 
    public void setNombreEd(String nombre){
        this.nombreEd=nombre;
    }

     /**
     * Método para obtener el elemento {@code nombreEd}.     
        @return String */ 
    public String getNombreEd(){
        return nombreEd;
    }

    @Override
    public String toString(){
        return "editorial: ("+nombreEd+", código ed: "+codigoEd
        +", año de creación : "+anoCreacion+')';
    }

}

/**
 * 
        Esta clase posee el propósito de simular y
        abstraer la noción de un libro escrito por una
        persona y/o editado-avalado por una editorial.
 * @version      
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
class Libro{

    /**  
        Código ISSN del libro */
    private int codigoISSN;

    /**  
        Número de páginas del libro. */
    private int numeroPaginas;

    /**  
       Título del libro. */
    private String titulo;

    /**  
       Autor del libro. */
    private Autor autor;

     /**  
        Editorial del libro */
    private Editorial editorial;

    /**
     * Método set para el elemento {@code codigoISSN}
        @param codigoISSN integro para determinar el código ISSN.     
        @return void */ 
    public void setCodigoISSN(int codigoISSN){
        this.codigoISSN=codigoISSN;
    }

    /**
     * Método para obtener el elemento {@code codigoISSN}
        @return int */
    public int getCodigoISSN(){
        return codigoISSN;
    }

    /**
     * Método set para el elemento {@code numeroPaginas}
        @param numeroPaginas integro para determinar el número de páginas.     
        @return void */
    public void setNumeroPaginas(int numeroPaginas){
        this.numeroPaginas=numeroPaginas;
    }

    /**
     * Método para obtner el elemento {@code numeroPaginas}   
        @return int*/
    public int getNumeroPaginas(){
        return numeroPaginas;
    }

    /**
     * Método set para el elemento {@code titulo}
        @param titulo cadena para obtener el titulo.     
        @return void */
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    /**
     * Método get para el elemento {@code titulo}    
        @return String */
    public String getTitulo(){
        return titulo;
    }

    /**
     * Método set para el elemento {@code autor}
        @param autor     
        @return void */
    public void setAutor(Autor autor){
       this.autor=autor;
    }

    /**
     * Métod get para el elemento {@code autor}
        @return Autor */
    public Autor getAutor(){
        return autor;
    }

    /**
     * Método set para el elemento {@code editorial}
        @param editorial   
        @return void */
    public void setEditorial(Editorial editorial){
        this.editorial=editorial;
    }

    /**
     * Métod get para el elemento {@code editorial}  
        @return Editorial */
    public Editorial getEditorial(){
        return editorial;
    }

    @Override
    public String toString(){
        return "El libro "+titulo+", con ISBN: "+codigoISSN+" del autor "+
        autor.getNombre()+", "+editorial+", tiene un número de páginas "+numeroPaginas;
    }

}
