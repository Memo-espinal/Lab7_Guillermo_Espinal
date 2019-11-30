
package lab7_guillermoespinal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class HiloBarra extends Thread{
    JProgressBar barra;
    private boolean vive;
    private boolean avanzar;
    bus Bus;
    ArrayList<estudiantes>estudiantes = new ArrayList<>();
    parada paradaact;
    parada paradasig;
    double x_global=0;
    double y_global=0;
    JTable tabla;
    
    /*double x_global2=0;
    double y_global2=0;*/
    ArrayList<parada> paradas = new ArrayList<>();

    public HiloBarra(JProgressBar barra,bus bus, ArrayList<parada> paradas,JTable tabla, ArrayList<estudiantes>estudiantes ) {
        this.barra = barra;
        this.Bus=bus;
        this.paradas=paradas;
        this.tabla = tabla;
        this.estudiantes= estudiantes;
//this.paradaact=parada;
        vive=true;
        avanzar=true;
    }
    

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    @Override
    public String toString() {
        return "HiloBarra{" + "barra=" + barra + ", vive=" + vive + ", avanzar=" + avanzar + '}';
    }
    
    @Override
    public void run(){
        //for (int i = 0; i < estudiantes.size(); i++) {
        //for no funcion, con cont??
        //cont si sale no lo toques
        int cont=0;
        try {
            
        
             while(vive){
           
            if(avanzar){
               
                    paradaact = estudiantes.get(cont).getParada();
                    double tiempo = distancia(paradaact, x_global, y_global)/Bus.getVelocidad();
                    System.out.println(tiempo);
                     barra.setMaximum((int)distancia(paradaact, tiempo, tiempo));
                    barra.setValue((int) (barra.getValue()+1));
                    double almacen = tiempo;
                   // if ((int)distancia(paradaact, x_global, y_global)==barra.getValue() ) {
                     Object[] newrow={
                            paradaact.getNombre(),
                            tiempo,
                            estudiantes.get(cont).getNombre() };
                      DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
                    modelo.addRow(newrow);
                    tabla.setModel(modelo);
                    barra.setValue(0);
                    cont++;
                   // }
                   
                    
                   
                }
                try
             {
                Thread.sleep(1000);
             }
             catch (InterruptedException ex) {
                 
                 
             }
           
            }
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,"termino");
        }
            
        
     //  }
    } 
    public double distancia(parada parada,double x,double y){
        double num=(Math.pow((parada.getX() -x), 2) + Math.pow((parada.getY()-y), 2));
        this.x_global=parada.getX();
        this.y_global=parada.getY();
        double d=Math.sqrt(num);
        return d;
      //  double t=d/Bus.getVelocidad();
    }
    
}
