package libro;
public class libro{
    public String titulo;
    public String autor;
    String fechaEdicion;
    String numPaginas;
    String editorial;
    String genero;
    String isbn;
    String ubicacion;
    String estado;
    String descripcion;

    public libro(String titulo, String autor,String fechaEdicion,String numPaginas, String editorial, String genero, String isbn, String ubicacion, String estado, String descripcion){
        this.titulo = titulo;
        this.autor = autor;
        this.fechaEdicion = fechaEdicion;
        this.numPaginas = numPaginas;
        this.editorial = editorial;
        this.genero = genero;
        this.isbn = isbn;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.descripcion = descripcion;
    };
    public String toString(){
        return "Titulo: \""+ titulo+"\", Autor: \'"+autor+"\""+", ISBN: "+isbn+", Estado: "+estado+"N°pags: "+numPaginas+"Genero: "+genero+"Ubicacion: "+ubicacion+"Descripcion: "+descripcion+"\n";
    };
    public String getTitulo(){
        return titulo;
    };
    public String getAutor(){
        return autor;
    };
    public String getISBN(){
        return isbn;
    };
    public void cambiarEstado(String est){
        this.estado = est;
    };
    public void editarTitulo(String nuevo){
        this.titulo = nuevo;
    };
    public void editarAutor(String nuevo){
        this.autor = nuevo;
    };
    public void editarEditorial(String nuevo){
        this.editorial = nuevo;
    };  
    public void editarFecha(String nuevo){
        this.fechaEdicion = nuevo;
    };
    public void editarPags(String nuevo){
        this.numPaginas = nuevo;
    };
    public void editarGenero(String nuevo){
        this.genero = nuevo;
    };
    public void editarISBN(String nuevo){
        this.isbn = nuevo;
    };
    public void editarDesc(String nuevo){
        this.descripcion = nuevo;
    };  
    public void editarUbicacion(String nuevo){
        this.ubicacion = nuevo;
    };      
};

