
package lab7_guillermoespinal;

import java.util.ArrayList;
import javax.swing.JProgressBar;


public class HiloBarra extends Thread{
    JProgressBar barra;
    private boolean vive;
    private boolean avanzar;
    bus Bus;
    parada paradaact;
    parada paradasig;
    double x_global=0;
    double y_global=0;
    double x_global2=0;
    double y_global2=0;
    ArrayList<parada> paradas = new ArrayList<>();

    public HiloBarra(JProgressBar barra,bus bus, ArrayList<parada> paradas ) {
        this.barra = barra;
        this.Bus=bus;
        this.paradas=paradas;
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
        while(vive){
           
            if(avanzar){
                for (parada parada1 : paradas) {
                    paradaact = parada1;
                    double tiempo = distancia(paradaact, x_global, y_global)/Bus.getVelocidad();
                                    System.out.println(tiempo);

                     barra.setMaximum((int)tiempo);
              
                    barra.setValue((int) (barra.getValue()+0.1));
              
                     //barra.setString(Integer.toString(barra.getValue()));
                    
                }
                try
             {
                Thread.sleep(1000);
             }
             catch (InterruptedException ex) {
                 
             }
             // double tiempo = distancia(paradaact, x_global, y_global)/Bus.getVelocidad();
               // System.out.println(tiempo);
                /*barra.setMaximum(tiempo.intValue());
                
                barra.setValue(barra.getValue()+1);
                
                barra.setString(Integer.toString(barra.getValue()));*/
            }
            
        
       }
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
