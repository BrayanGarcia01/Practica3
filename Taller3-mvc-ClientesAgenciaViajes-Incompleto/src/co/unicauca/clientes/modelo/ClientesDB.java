package co.unicauca.clientes.modelo;

import java.util.ArrayList;

/**
 *
 * @author Libardo, Ricardo Zambrano Simula los clientes que se manipulan desde
 * una base de datos Es el observable
 */
public class ClientesDB extends java.util.Observable {
    
    private ArrayList<Cliente> clientes;

    private String profesion;
    private ArrayList<Cliente> clientesPorProfesion;
    private int totalHombres;
    private int totalMujeres;
    private double porcentajeHombres;
    private double porcentajeMujeres;

    public ClientesDB() {
        inicializarDatos();
    }

    private void inicializarDatos() {
        clientes = new ArrayList();
        clientes.add(new Cliente("Mario Alejandro Perez", "Ingeniero(a)", "M"));
        clientes.add(new Cliente("Fernanda Andrea Meneses Ordoñez", "Ingeniero(a)", "F"));
        clientes.add(new Cliente("Andrea Soto Melo", "Ingeniero(a)", "F"));
        clientes.add(new Cliente("Andrea Garcia", "Ingeniero(a)", "F"));
        clientes.add(new Cliente("Andrea Sanchez", "Ingeniero(a)", "F"));

        clientes.add(new Cliente("Carlos Andres Salamanca ", "Medico(a)", "M"));
        clientes.add(new Cliente("Mario Alberto Andrade", "Medico(a)", "M"));
        clientes.add(new Cliente("Jesús Adrián Romero", "Medico(a)", "M"));

        clientes.add(new Cliente("Federico Mendez", "Abogado(a)", "M"));
        clientes.add(new Cliente("Carlos Yepez", "Abogado(a)", "M"));
        clientes.add(new Cliente("Sofia Andrade", "Abogado(a)", "F"));

        clientes.add(new Cliente("Maria Del Pilar Santacruz", "Comerciante", "F"));
        clientes.add(new Cliente("Rodrigo de Jesus Ortega", "Comerciante", "M"));
        clientes.add(new Cliente("Carlota Marcela Hernandez", "Comerciante", "F"));
        clientes.add(new Cliente("Ericka Galvis", "Comerciante", "F"));
        clientes.add(new Cliente("Vercia Garcia", "Comerciante", "F"));
        clientes.add(new Cliente("Maria Sanchez", "Comerciante", "F"));
        clientes.add(new Cliente("Claudia del Pilar Valencia", "Comerciante", "F"));
        clientes.add(new Cliente("Esperanza Doria Arteaga", "Comerciante", "F"));
    }

    /**
     * Busca los clientes de una profesion. Cambia el estado del objeto y
     * notifica a los observadores
     *
     * @param profesion profesión
     */
    public void buscarClientesPorProfesion(String profesion) {
        this.profesion = profesion;
        clientesPorProfesion = new ArrayList();
        this.totalHombres = 0;
        this.totalMujeres = 0;

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cli = clientes.get(i);
            if (cli.getProfesion().equalsIgnoreCase(profesion)) {
                clientesPorProfesion.add(cli);
            }
        }
        setChanged();
        notifyObservers();
    }
    
    public void BuscarClientesPorSexo(){
        //activarVistaEstadistica=true;
        totalHombres=0;
        totalMujeres=0;
        for(int i=0;i<clientesPorProfesion.size();i++){
            if(clientesPorProfesion.get(i).getSexo().equalsIgnoreCase("M")){
                totalHombres++;
            }else{
                totalMujeres++;
            }
              
        }
        setChanged();
        notifyObservers();
    }
    
    
    public void agregarCliente(String nombres, String profesion, String sexo){
        clientes.add(new Cliente(nombres, profesion, sexo));
    }
    
    public void borrarClientes(){
        clientes = new ArrayList();
    }

    public ArrayList<Cliente> getClientesPorProfesion() {
        return clientesPorProfesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public double getPorcentajeHombres() {
        if(clientesPorProfesion.size()==0){
            return 0;
        }else{
            double x=(double)totalHombres/clientesPorProfesion.size();
            x=(double)x*100;
            x=Math.round(x *100d)/100d;
            return (x);
        }
    }

    public double getPorcentajeMujeres() {
        if(clientesPorProfesion.size()==0){
            return 0;
        }else{
            double x=(double)totalMujeres/clientesPorProfesion.size();
            x=(double)x*100;
            x=Math.round(x *100d)/100d;
            return (x);
        }

    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getTotalHombres() {
        return totalHombres;
    }

    public int getTotalMujeres() {
        return totalMujeres;
    }



    
}
