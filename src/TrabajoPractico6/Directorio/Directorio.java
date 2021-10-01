 package TrabajoPractico6.Directorio;

import java.util.*;

public class Directorio {
    private HashMap<String,Cliente> directorio;

    public Directorio() {
        this.directorio = new HashMap<>();
    }
    
    public HashMap<String, Cliente> getDirectorio(){
        return directorio;
    }
    
    public void agregarCliente(String telefono, String nombre, String apellido, String dni, String ciudad, String domicilio){
        directorio.put(telefono, new Cliente(nombre, apellido, dni, ciudad, domicilio));
    }
    
    public Cliente buscarCliente(String telefono){
        if(telefono != null){
            if(directorio.containsKey(telefono)){
                return directorio.get(telefono);
            } else {
                System.out.println("El cliente solicitado no existe");
                return null;
            }
        } else {
            System.out.println("Ingrese número de teléfono");
            return null;
        }
    }
    
    public ArrayList<String> buscarTelefono(Object apellido) {
        ArrayList<String> telefonos = new ArrayList<>();
        if (apellido instanceof String) {
            if(apellido != null){
                Collection<Cliente> clientes = directorio.values();
                boolean control = false;

                for (Map.Entry<String, Cliente> e:directorio.entrySet()) {
                    if(e.getValue().getApellido().equals(apellido)){
                        control = true;
                         e.getKey();
                    }
                }
            }
        } if (apellido instanceof Cliente) {
            Cliente cli = (Cliente)apellido;
            
            for (Map.Entry<String, Cliente> e:directorio.entrySet()) {
                if(e.getValue().equals(cli)){
                    e.getKey();
                }
            }
        }
        
        return telefonos;
    }
    
    public ArrayList<Cliente> buscarClientes(String ciudad){
        ArrayList<Cliente> clientes = new ArrayList<>();
        if (ciudad.equals("*")){
            directorio.entrySet().forEach((e) -> {
                clientes.add(e.getValue());
            });
        } else if(ciudad != null){
            boolean control = false;
            
            for (Map.Entry<String, Cliente> e:directorio.entrySet()) {
                if(e.getValue().getCiudad().equals(ciudad)){
                    control = true;
                    clientes.add(e.getValue());
                }
            }
            
            if(!control){
                System.out.println("El valor ingresado no existe");
                return null;
            }
        } else {
            System.out.println("Ingrese ciudad");
            return null;
        }
        return clientes;
    }
    
    public void borrarCliente(String dni){
        if(dni != null){
            Collection<Cliente> clientes = directorio.values();
            boolean control = false;
            
            for (Map.Entry<String, Cliente> e:directorio.entrySet()) {
                if(e.getValue().getDni().equals(dni)){
                    control = true;
                    directorio.remove(e.getKey());
                }
            }
            
            if(!control){
                System.out.println("El valor ingresado no existe");
            } else {
                System.out.println("Valor eliminado correctamente");
            }
        } else {
            System.out.println("Ingrese apellido");
        }
    }
}
