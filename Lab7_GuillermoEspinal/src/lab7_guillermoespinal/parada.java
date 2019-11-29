/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_guillermoespinal;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class parada implements Serializable {

    // contendrán nombre, distancia(km), Angulo(rad), coordenada en x y coordenada en y.
    //Las coordenadas en “x” y en “y” se calcularán utilizando las siguientes formulas: 
    private String nombre;
    private double distancia;
    private double angulo;
    private double x;
    private double y;

    private static final long SerialVersionUID = 777L;

    public parada() {
    }

    public parada(String nombre, double distancia, double angulo) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.angulo = angulo;
        setX(angulo);
        setY(angulo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {

        this.angulo = angulo;
    }

    public double getX() {
        return x;
    }

    public void setX(double angulo) {
        this.x = distancia * Math.cos(x);
    }

    public double getY() {
        return y;
    }

    public void setY(double angulo) {
        this.y = distancia * Math.sin(angulo);
    }

    @Override
    public String toString() {
        return nombre + " " + distancia;//"parada{" + "nombre=" + nombre + ", distancia=" + distancia + ", angulo=" + angulo + ", x=" + x + ", y=" + y + '}';
    }

}
