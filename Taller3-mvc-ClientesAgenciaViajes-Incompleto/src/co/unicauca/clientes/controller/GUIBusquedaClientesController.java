package co.unicauca.clientes.controller;

import co.unicauca.clientes.modelo.ClientesDB;
import co.unicauca.clientes.vista.GUIBusquedaClientes;
import co.unicauca.clientes.vista.GUIClientesProfesion;
import co.unicauca.clientes.vista.GUIEstadisticaPorSexo;
import co.unicauca.clientes.vista.GUIEstadisticaPorSexoGrafica;
import java.awt.event.ActionEvent;

/**
 *
 * @author Libardo Pantoja, Ricardo Zambrano Controlador de la
 * GUIBusquedaClientes. Es la unica que tiene un controlador porque cambia el
 * estado del modelo. Las otras GUIs tienen el controlador dentro de la misma
 * vista.
 */
public class GUIBusquedaClientesController implements java.awt.event.ActionListener {

    private ClientesDB modelo;
    private GUIBusquedaClientes vista;
    private GUIClientesProfesion vista2;
    private GUIEstadisticaPorSexo vista3;
    private GUIEstadisticaPorSexoGrafica vista4;

    @Override
    public void actionPerformed(ActionEvent e) {
        vista2.setVisible(true);
        vista4.setVisible(false);
        vista3.setVisible(false);
        vista2.SetButtonVisible(true);
        modelo.buscarClientesPorProfesion(vista.getProfesion());
        
    }

    public void addModel(ClientesDB m) {
        this.modelo = m;
    }

    public void addView(GUIBusquedaClientes v) {
        this.vista = v;
    }
    
    public void addView(GUIClientesProfesion v) {
        this.vista2 = v;
    }
    public void addView(GUIEstadisticaPorSexo v) {
        this.vista3 = v;
    }
    public void addView(GUIEstadisticaPorSexoGrafica v) {
        this.vista4 = v;
    }

}
