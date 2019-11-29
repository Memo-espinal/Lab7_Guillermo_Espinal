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
public class adminParadas {
    private File archivo;
    private ArrayList<parada>paradas = new ArrayList<>();

    public adminParadas() {
    }

    public adminParadas(String path) {
        this.archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<parada> getParadas() {
        return paradas;
    }

    public void setParadas(ArrayList<parada> paradas) {
        this.paradas = paradas;
    }
    //me did it
    public void addParada(parada parada){
        this.paradas.add(parada);
    }

    @Override
    public String toString() {
        return "adminParadas{" + "archivo=" + archivo + ", paradas=" + paradas + '}';
    }
     public void cargarArchivo() {
        try {            
            paradas = new ArrayList();
            parada temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (parada) objeto.readObject()) != null) {
                        paradas.add(temp);
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
            for (parada t : paradas) {
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
