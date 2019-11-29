
package lab7_guillermoespinal;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;


public class bus implements Serializable{
    //tendrá un numero de identificación, placa, color, velocidad(km/h) y estudiantes.
    private int id;
    private String placa;
    private Color color;
    private double velocidad;
    ArrayList<estudiantes>estudiantes = new ArrayList<>();
    
    private static final long SerialVersionUID=777L;


    public bus() {
    }

    public bus(int id, String placa, Color color, double velocidad) {
        this.id = id;
        this.placa = placa;
        this.color = color;
        this.velocidad = velocidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public ArrayList<estudiantes> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<estudiantes> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public void addEstudiante(estudiantes estudiante){
        estudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return "Bus:"+id;//"bus{" + "id=" + id + ", placa=" + placa + ", color=" + color + ", velocidad=" + velocidad + ", estudiantes=" + estudiantes + '}';
    }
    
}
