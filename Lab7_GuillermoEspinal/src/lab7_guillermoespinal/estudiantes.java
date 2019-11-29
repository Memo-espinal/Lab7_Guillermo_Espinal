
package lab7_guillermoespinal;

import java.io.Serializable;


public class estudiantes implements Serializable{
    // tendrán un nombre, edad, número de cuenta, parada. 
    private  String nombre;
    private int edad;
    private int cuenta;
    private parada parada;
        
    private static final long SerialVersionUID=777L;


    public estudiantes() {
    }

    public estudiantes(String nombre, int edad, int cuenta, parada parada) {
        this.nombre = nombre;
        this.edad = edad;
        this.cuenta = cuenta;
        this.parada = parada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public parada getParada() {
        return parada;
    }

    public void setParada(parada parada) {
        this.parada = parada;
    }

    @Override
    public String toString() {
        return nombre + cuenta+parada;//"estudiantes{" + "nombre=" + nombre + ", edad=" + edad + ", cuenta=" + cuenta + ", parada=" + parada + '}';
    }
    
    
}
