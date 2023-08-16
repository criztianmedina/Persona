package Persona;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CRISTIAN MEDINA
 */
public class Conexion {

    private ObjectContainer oc;
    ArrayList<Persona> datos = new ArrayList<Persona>();

    private void open() {
        this.oc = Db4o.openFile("DBmodelo.db4o");
    }

    public boolean Insertar(Persona Objeto) {
        try {
            this.open();

            oc.set(Objeto);
            this.oc.close();
            return true;

        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            JOptionPane.showMessageDialog(null, "  bdoo.controlador,insertarModelo() ;" + e);
            return false;
        }
    }

    public void Registro(Persona Objeto) {
        this.open();
        String lista1 = "";
        Persona encontrado = null;
        ObjectSet resultados = this.oc.queryByExample(Objeto);
        while (resultados.hasNext()) {
            encontrado = (Persona) (resultados.next());
            lista1 = lista1 + "\n" + encontrado.toString();
            // JOptionPane.showMessageDialog(null,encontrado.toString());
        }
        JOptionPane.showMessageDialog(null, lista1);
        this.oc.close();
    }

    public void Eliminar(Persona Objeto) {
        String nom = " ";
        this.open();
        Persona encontrado = null;
        //consulto los objetos encontrados 
        ObjectSet resultados = this.oc.queryByExample(Objeto);
        while (resultados.hasNext()) {
            encontrado = (Persona) resultados.next();
            // Borro los objetos encontrados 
            oc.delete(encontrado);
            nom = encontrado.getNombre();
        }
        this.oc.close();
        JOptionPane.showMessageDialog(null, "EL objeto borrado  " + nom);
    }

    public void Actualizar(Persona buscar, String nombre) {
        this.open();
        Persona encontrado = null;
        ObjectSet resultado = this.oc.queryByExample(buscar);
        while (resultado.hasNext()) {
            encontrado = (Persona) resultado.next();
            ;
            //Actualizar objeto 
            encontrado.setNombre(nombre);
            //guardamos el objeto de nuevo actualizandolo 
            oc.store(encontrado);
        }
        this.oc.close();

        JOptionPane.showMessageDialog(null, "Objeto Actualizado " + encontrado.getNombre());
    }

    public Persona buscarModelo(Persona objeto) {
        this.open();
        String enc = "";
        Persona encontrado = null;
        ObjectSet resultados = this.oc.get(objeto);
        
        while (resultados.hasNext()) {
            encontrado = (Persona) resultados.next();
            Persona noencontrado = null;
                encontrado=noencontrado;
             if (noencontrado!=resultados) {
               JOptionPane.showMessageDialog(null, "xxxxx");
               noencontrado=encontrado;
            }
        }
        this.oc.close();
        return encontrado;       
    }
}

