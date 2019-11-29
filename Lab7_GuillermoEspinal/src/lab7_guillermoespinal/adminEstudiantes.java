/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_guillermoespinal;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class adminEstudiantes {
      private File archivo;
    private ArrayList<estudiantes>estudiantes = new ArrayList<>();

    public adminEstudiantes() {
    }

    public adminEstudiantes(String path) {
        this.archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<estudiantes> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<estudiantes> estudiantes) {
        this.estudiantes = estudiantes;
    }
    //me did it
    public void addEstudiantes(estudiantes estudiante){
        this.estudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return "adminEstudiantes{" + "archivo=" + archivo + ", estudiantes=" + estudiantes + '}';
    }
    
     public void cargarArchivo() {
        try {            
            estudiantes = new ArrayList();
            estudiantes temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (estudiantes) objeto.readObject()) != null) {
                        estudiantes.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
     
     public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (estudiantes t : this.estudiantes) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
    
    
}
