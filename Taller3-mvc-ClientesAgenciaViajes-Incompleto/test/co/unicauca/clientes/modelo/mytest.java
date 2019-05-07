
package co.unicauca.clientes.modelo;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class mytest {
    public static void main(String[] args){
        System.out.println("Clientes por profesión");
        ClientesDB instance = new ClientesDB();

        instance.borrarClientes();
        instance.agregarCliente("Andres Perez", "Ingeniero(a)", "M");
        instance.agregarCliente("Andrea Ruiz", "Ingeniero(a)", "F");
        instance.agregarCliente("Carlos Andrade", "Ingeniero(a)", "M");
        instance.agregarCliente("Maria Sotelo", "Medico(a)", "F");

        instance.buscarClientesPorProfesion("Medico(a)");
        
        ArrayList<Cliente> result = instance.getClientesPorProfesion();

        
    }
}
