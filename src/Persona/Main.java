package Persona;

import Persona.Persona;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author CRISTIAN MEDINA
 */
public class Main {

    private static String Persona;
    public static void main(String[] args) {
        int opcion = 0;
        Persona p1 = new Persona("Cristian\n", "Medina\n", 1);
        Persona Lista = new Persona();
        Conexion c = new Conexion();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escoja una opcion:\n"
                    + "1. Insertar\n"
                    + "2. Eliminar\n"
                    + "3. Actualizar\n"
                    + "4. Registro\n"
                    + "5. Buscar\n"
                    + "6. Salir\n"));
            switch (opcion) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Ingrese");
                    String a = JOptionPane.showInputDialog("Ingrese el nombre");
                    String b = JOptionPane.showInputDialog("Ingrese el Apellido");
                    int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI"));
                    Persona ing = new Persona(a, b, n);
                    c.Insertar(ing);
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Eliminar");
                    String nom = JOptionPane.showInputDialog("Ingrese el nombre a Eliminar");
                    Persona busc = new Persona(nom);
                    c.Eliminar(busc);
                    break;
                    
                case 3:
                    JOptionPane.showMessageDialog(null, "Actualizar");
                    String nb = JOptionPane.showInputDialog("Ingrese el nombre a Actualizar");
                    Persona busca = new Persona(nb);
                    String act = JOptionPane.showInputDialog("Ingrese el nuevo Nombre");
                    c.Actualizar(busca, act);
                    break;
                    
                case 4:                    
                    JOptionPane.showMessageDialog(null, "Registro");
                    c.Registro(Lista);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Buscar");
                    String Bn = JOptionPane.showInputDialog("Ingrese el nombre a buscar");
                    Persona encontrar = new Persona(Bn);                      
                    c.Registro(encontrar );                    
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Salir");
                    return;
            }
        } while (opcion != 6);
        System.exit(0);
    }
}
