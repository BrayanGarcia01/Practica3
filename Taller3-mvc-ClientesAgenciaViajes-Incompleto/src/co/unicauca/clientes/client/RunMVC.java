package co.unicauca.clientes.client;

import co.unicauca.clientes.controller.GUIBusquedaClientesController;
import co.unicauca.clientes.controller.GUIEstadisticaPorSexoController;
import co.unicauca.clientes.modelo.ClientesDB;
import co.unicauca.clientes.vista.GUIBusquedaClientes;
import co.unicauca.clientes.vista.GUIClientesProfesion;
import co.unicauca.clientes.vista.GUIEstadisticaPorSexo;
import co.unicauca.clientes.vista.GUIEstadisticaPorSexoGrafica;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author Libardo Pantoja, Ricardo Zambrano
 */
public class RunMVC {

    public RunMVC() {;

        ClientesDB myModel = new ClientesDB();
        GUIBusquedaClientes myView = new GUIBusquedaClientes(400, 50);    
        GUIClientesProfesion myView2 = new GUIClientesProfesion(400,250);  
        GUIEstadisticaPorSexo myView3= new GUIEstadisticaPorSexo(600,450);
        GUIEstadisticaPorSexoGrafica myView4= new GUIEstadisticaPorSexoGrafica();
        
        myModel.addObserver(myView);
        myModel.addObserver(myView2);
        myModel.addObserver(myView3);
        myModel.addObserver(myView4);

        
        GUIBusquedaClientesController myController = new GUIBusquedaClientesController();
        myController.addModel(myModel);
        myController.addView(myView);
        myController.addView(myView2);
        myController.addView(myView3);
        myController.addView(myView4);
        myView.addController(myController);
        
        GUIEstadisticaPorSexoController myController2=new GUIEstadisticaPorSexoController();
        myController2.addModel(myModel);
        myController2.addView(myView2);
        myController2.addView(myView3);
        myController2.addView(myView4);
        myView2.addController(myController2);
        
        
        
        
    }

}
