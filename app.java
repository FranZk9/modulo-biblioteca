import java.util.*;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import libro.libro;
public class app {
  public static libro crearLibro(String[] infos){
    String name = infos[0];
    String autor = infos[1];
    String fechaEdicion = infos[2];
    String numPaginas = infos[3];
    String editorial = infos[4];
    String genero = infos[5];
    String isbn = infos[6];
    String ubicacion = infos[7];
    String estado = infos[8];
    String descripcion = infos[9];
    return new libro(name, autor, fechaEdicion, numPaginas, editorial, genero, isbn, ubicacion, estado, descripcion);
  }
  public static void main(String[] args) throws IOException{
    List<libro> libros= new ArrayList<>();
    BufferedReader iniciales = new BufferedReader(new FileReader("iniciales.csv"));
    String linea;
    while((linea = iniciales.readLine()) != null){
      String[] atributos = linea.split(";");
      libro libroNuevo = crearLibro(atributos);
      libros.add(libroNuevo);
      //iniciales.readLine();
    }
    Scanner scan = new Scanner(System.in);
    int opcion = 1;
    while(opcion != 9){
      System.out.println("====================LIBROS REGISTRADOS====================\n"+libros+"\n==========================================================\n");
      System.out.println("  ========MENU=========  \n|| 1 - Registrar libro ||\n|| 2 - ELiminar libro  ||\n|| 3 - Buscar libro    ||\n|| 4 - Editar libro    ||\n|| 5 - Cambiar estado  ||\n|| 6 - Salir           ||\n  ====================  ");
      System.out.print("Opción escogida: ");
      try{
        opcion = scan.nextInt();
        switch(opcion){
          case 1:
            Scanner info = new Scanner(System.in);
            // -------------
            System.out.print("Ingresar titulo: ");
            String titLibro = info.nextLine();
            // ---------------
            System.out.print("Ingresar autor(es): ");
            String autLibro = info.nextLine();
            // -------------
            System.out.print("Ingresar fecha de edicion: ");
            String fecLibro = info.nextLine();
            // ---------------
            System.out.print("Ingresar numero de paginas: ");
            String pagsLibro = info.nextLine();
            // -------------
            System.out.print("Ingresar editorial: ");
            String editLibro = info.nextLine();
            // ---------------
            System.out.print("Ingresar genero: ");
            String genLibro = info.nextLine();
            // -------------
            System.out.print("Ingresar ISBN: ");
            String isbnLibro = info.nextLine();
            // ---------------
            System.out.print("Ingresar ubicacion: ");
            String ubiLibro = info.nextLine();
            // -------------
            System.out.print("Ingresar estado (1-Prestado, 2-Disponible, 3-Extraviado): ");
            String estLibro = info.nextLine();
            // ---------------
            System.out.print("Ingresar descripcion: ");
            String descLibro = info.nextLine();

            libro libroNuevo = new libro(titLibro, autLibro, fecLibro, pagsLibro, editLibro, genLibro, isbnLibro, ubiLibro, estLibro, descLibro); // agregrar
            libros.add(libroNuevo);
            System.out.println("Libro "+libros.size()+" "+libroNuevo+" registrado correctamente\n");
            break;
          case 2: 
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Libros disponibles"+libros);
            System.out.println("Ingresar posición de libro a eliminar: ");
            int aEliminar = scan2.nextInt();
            aEliminar = aEliminar - 1;
            libros.remove(aEliminar);
            break;
          case 3:
            Scanner scan3 = new Scanner(System.in);
            System.out.println("Buscar por\n   1 - Nombre\n   2 - Autor\n   3 - ISBN");
            int por = scan3.nextInt();
            if (por==1){
              Scanner tituloBuscar = new Scanner(System.in);
              System.out.print("Titulo que desea buscar: ");
              String aBuscar = tituloBuscar.nextLine();
              for(int j=0; j<libros.size(); j++){
                libro tittle = libros.get(j);
                String tittleString = tittle.getTitulo();
                if(tittleString.contains(aBuscar)){
                  System.out.println("Coincide con "+tittle);
                }
              }
            }
            else if(por==2){
              Scanner autorBuscar = new Scanner(System.in);
              System.out.print("Autor por el que desea buscar: ");
              String aBuscar2 = autorBuscar.nextLine();
              for(int j=0; j<libros.size(); j++){
                libro author = libros.get(j);
                String authorString = author.getAutor();
                if(authorString.contains(aBuscar2)){
                  System.out.println("Coincide con "+author+"\n");
                }
              }
            }
            else if(por == 3){
              Scanner isbnBuscar = new Scanner(System.in);
              System.out.print("ISBN por el que desea buscar: ");
              String aBuscar3 = isbnBuscar.nextLine();
              for(int j=0; j<libros.size(); j++){
                libro isbnA = libros.get(j);
                String isbnString = isbnA.getISBN();
                if(isbnString.contains(aBuscar3)){
                  System.out.println("Coincide con "+isbnA+"\n");
                }
              }

            }
            break;
          case 4:
            Scanner scan4 = new Scanner(System.in);
            System.out.print("Posición del libro a cambiar: ");
            int pos = scan4.nextInt();
            pos = pos -1;
            scan4.nextLine();
            System.out.print("Atributo a editar:\n 1 - Titulo\n 2 - Autor(es)\n 3 - Fecha de edicion\n 4 - N°paginas\n 5 - Editorial\n 6 - Genero\n 7 - ISBN\n 8 - Ubicacion\n 9 - Descripcion");
            int op = scan4.nextInt();
            scan4.nextLine();
            if (op==1){
              String tituloNuevo = scan4.nextLine();
              libro seleccionado = libros.get(pos);
              seleccionado.editarTitulo(tituloNuevo);
            }
            else if (op==2){
              String autorNuevo = scan4.nextLine();
              libro seleccionado = libros.get(pos);
              seleccionado.editarAutor(autorNuevo);
            }
            else if (op==3){
              String fechaNueva = scan4.nextLine();
              libro seleccionado = libros.get(pos);
              seleccionado.editarFecha(fechaNueva);
            }
            else if (op==4){
              String pagNuevas = scan4.nextLine();
              libro seleccionado = libros.get(pos);
              seleccionado.editarFecha(pagNuevas);
            }
            else if (op==5){
              String editNueva = scan4.nextLine();
              libro seleccionado = libros.get(pos);
              seleccionado.editarEditorial(editNueva);
            }
            else if (op==6){
              String generoNuevo = scan4.nextLine();
              libro seleccionado = libros.get(pos);
              seleccionado.editarGenero(generoNuevo);
            }
            else if (op==7){
              String isbnNuevo = scan4.nextLine();
              libro seleccionado = libros.get(pos);
              seleccionado.editarISBN(isbnNuevo);
            }
            else if (op==8){
              String ubiNueva = scan4.nextLine();
              libro seleccionado = libros.get(pos);
              seleccionado.editarUbicacion(ubiNueva);
            }
            else if (op==8){
              String desNueva = scan4.nextLine();
              libro seleccionado = libros.get(pos);
              seleccionado.editarDesc(desNueva);
            }
            break;
          case 5:
            Scanner scan5 = new Scanner(System.in);
            System.out.print("Posición del libro a cambiar: ");
            int pos2 = scan5.nextInt();
            scan5.nextLine();
            pos2 = pos2 -1;
            System.out.print("Nuevo estado: ");
            String estNuevo = scan5.nextLine();
            //System.out.print(libros.get(pos));
            libro seleccionado = libros.get(pos2);
            seleccionado.cambiarEstado(estNuevo);
            break;
          case 6: exit(0);
        }
      }
      catch (Exception ex){
        System.out.println("Ingresar opción válida");
        scan.next();
      }
      
    
    }
  scan.close();
  iniciales.close();
  }
  
}