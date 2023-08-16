package Persona;

/**
 *
 * @author CRISTIAN MEDINA
 */
public class Persona {
    
    String nombre,apellido;
    int id;

    public Persona(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public  Persona(){   
    }
    
    public Persona (String nombre){
     this.nombre=nombre;  
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
      public String toString(){
     return "Nombre :  "+nombre+"\n"+"Apellido:  "+apellido+"\n"+"DNI:  "+id+"\n"+"-----------------------------------";
    } 
}
