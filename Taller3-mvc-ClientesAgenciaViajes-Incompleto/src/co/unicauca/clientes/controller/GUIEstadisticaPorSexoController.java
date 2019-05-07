
package co.unicauca.clientes.controller;

import co.unicauca.clientes.modelo.ClientesDB;
import co.unicauca.clientes.vista.GUIClientesProfesion;
import co.unicauca.clientes.vista.GUIEstadisticaPorSexo;
import co.unicauca.clientes.vista.GUIEstadisticaPorSexoGrafica;
import java.awt.event.ActionEvent;



public class GUIEstadisticaPorSexoController implements java.awt.event.ActionListener {
    private ClientesDB modelo;
    private GUIClientesProfesion vista;
    private GUIEstadisticaPorSexo vista2;
    private GUIEstadisticaPorSexoGrafica vista3;
    @Override
    public void actionPerformed(ActionEvent e) {
        
        vista2.setVisible(true);
        vista3.setVisible(true);
        vista3.setAnteriorH(modelo.getPorcentajeHombres());
        vista3.setAnteriorM(modelo.getPorcentajeMujeres());
        modelo.BuscarClientesPorSexo();
        
        
    }
    
        public void addModel(ClientesDB m) {
        this.modelo = m;
    }

    public void addView(GUIClientesProfesion v) {
        this.vista = v;
    }
    public void addView(GUIEstadisticaPorSexo v) {
        this.vista2 = v;
    }
    public void addView(GUIEstadisticaPorSexoGrafica v) {
        this.vista3 = v;
    }
    
}
