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
        Esta es la clase de prueba de 
        LibroImplementation
 * @version      
        17.0.6 06 Jan 2023  @author          
        Jorge Celis  */
public class AppLibro {
    public static void main(String[] args){

        //Declaramos dos instancias de la clase Autor.
        Autor writer1=new Autor(),
        writer2=new Autor();

        //Determinamos los nombres de los autores.
        writer1.setNombre("Andrew Roberts");
        writer2.setNombre("Wolfram Eilenberger");

        //Determinamos las identidades de los autores. 
        writer1.setId(1848);
        writer2.setId(1977);

        //Determinamos el pais de origen de los autores. 
        writer1.setPaisOrigen("England");
        writer2.setPaisOrigen("Germany");

        //Declaramos dos instancias de la clase Editorial.
        Editorial ed1=new Editorial(),ed2=new Editorial();

        //Establecemos las propiedades de ed1. 
        ed1.setNombreEd("Penguin Books");
        ed1.setAnoCreacion(1934);
        ed1.setCodigoEd(239912233);

        //Establecemos las propiedades de ed2. 
        ed2.setNombreEd("Penguin Random House");
        ed2.setAnoCreacion(2013);
        ed2.setCodigoEd(1002993122);

        //Declaramos tres instancias de la clase Libro. 
        Libro libro1=new Libro(), libro2=new Libro(),
        libro3=new Libro();

        //Establecemos los autores de los libros.
        libro1.setAutor(writer1);
        libro2.setAutor(writer1);
        libro3.setAutor(writer2);

        //Establecemos las editoriales de los libros.
        libro1.setEditorial(ed1);
        libro2.setEditorial(ed1);
        libro3.setEditorial(ed2);

        //Establecemos los titulos de los libros.
        libro1.setTitulo("Napoleon, a Life");
        libro2.setTitulo("Winston Spencer Churchill");
        libro3.setTitulo("Tiempos de Magos");

        //Establecemos los códigos ISSN de los libros.
        libro1.setCodigoISSN(23812331);
        libro2.setCodigoISSN(23192351);
        libro3.setCodigoISSN(239488812);

        //Establecemos el número de páginas de los libros.
        libro1.setNumeroPaginas(1443);
        libro2.setNumeroPaginas(1712);
        libro3.setNumeroPaginas(678);
        
        //Mostramos por consola los datos de los libros. 
        System.out.println(libro1+"\n");
        System.out.println(libro2+"\n");
        System.out.println(libro3+"\n");

        //Mostramos por consola cual de los tres libros tiene más páginas.
        int acumuladorNumeroPaginas=0;
        Libro[] arregloLibros={libro1, libro2, libro3};
        for (var x:arregloLibros){
            if (x.getNumeroPaginas()>=acumuladorNumeroPaginas) 
            acumuladorNumeroPaginas=x.getNumeroPaginas();
        }
        for (var k: arregloLibros){
            if (k.getNumeroPaginas()==acumuladorNumeroPaginas){
                System.out.println("\nEl libro con mayor número de páginas es el libro "
                +k.getTitulo()+" de "+k.getAutor().getNombre()+'.');
                break;
            }
        }
    }
}
