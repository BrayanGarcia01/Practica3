package co.unicauca.clientes.vista;

import co.unicauca.clientes.modelo.ClientesDB;
import java.util.Observable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author danielmej
 */
public class GUIEstadisticaPorSexoGrafica  implements java.util.Observer{
    double anteriorH=0;
    double anteriorM=0;
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    JFreeChart chart=ChartFactory.createBarChart3D("Estadistica por sexo", "Comparar", "Porcentaje", dataset,PlotOrientation.VERTICAL,true,true,true);
    ChartFrame f = new ChartFrame("porcentaje",chart);
    
    
    
    public GUIEstadisticaPorSexoGrafica() {
        dataset.addValue(0, "Mujeres", String.valueOf(anteriorM)+"%");
        dataset.addValue(0, "Hombres", String.valueOf(anteriorH)+"%" );
        f.setSize(400,300);
        f.setLocation(830,450);
        f.setVisible(false);
    
    }
    public void setVisible(boolean valor){
        f.setVisible(valor);
    }

    @Override
    public void update(Observable o, Object arg) {
        
        ClientesDB cliDB = (ClientesDB) o;
        //f.setVisible(cliDB.isActivarVistaEstadistica());
        dataset.removeValue("Mujeres", String.valueOf(anteriorM)+"%");
        dataset.removeValue("Hombres", String.valueOf(anteriorH)+"%" ); 
        double x=cliDB.getPorcentajeMujeres();
        anteriorM=x;
        dataset.addValue(x, "Mujeres", String.valueOf(x)+"%");
        x=cliDB.getPorcentajeHombres();
        anteriorH=x;
        dataset.addValue(x, "Hombres", String.valueOf(x)+"%");
        chart=ChartFactory.createBarChart3D("Estadistica por sexo", "Comparar", "Porcentaje", dataset,PlotOrientation.VERTICAL,true,true,true);

    }

    public void setAnteriorH(double anteriorH) {
        this.anteriorH = anteriorH;
    }

    public void setAnteriorM(double anteriorM) {
        this.anteriorM = anteriorM;
    }

    public double getAnteriorH() {
        return anteriorH;
    }

    public double getAnteriorM() {
        return anteriorM;
    }
    
    
    
}
