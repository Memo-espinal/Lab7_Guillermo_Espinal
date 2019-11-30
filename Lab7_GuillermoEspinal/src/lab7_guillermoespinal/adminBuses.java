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
public class adminBuses {
      private File archivo;
    private ArrayList<bus>buses = new ArrayList<>();

    public adminBuses() {
    }

    public adminBuses(String path) {
        this.archivo = new File (path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<bus> getBuses() {
        return buses;
    }

    public void setBuses(ArrayList<bus> buses) {
        this.buses = buses;
    }
    //me did it
    public void addBuses(bus bus){
        this.buses.add(bus);
    }
    @Override
    public String toString() {
        return "adminBuses{" + "archivo=" + archivo + ", buses=" + buses + '}';
    }
     public void cargarArchivo() {
        try {            
            buses = new ArrayList();
            bus temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (bus)objeto.readObject()) != null) {
                        buses.add(temp);
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
            for (bus t : buses) {
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
