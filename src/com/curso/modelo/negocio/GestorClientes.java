package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteDao;

public class GestorClientes {

	private ClienteDao clienteDao = new ClienteDao();
	
	
	public void insertar(Cliente cliente){
		// proceso a seguir para insertar un cliente
		// ejemplo inventado
		// asociar el cliente a un comercial
		// Enviar correo a ese comercial
		// Insertar cliente en BBDD
		// enviar correo al nuevo cliente
		System.out.println("GestorClientes: insertando"+cliente);
		clienteDao.insertar(cliente);
	}
	
	public List<Cliente> listarTodos(){
		return clienteDao.listarTodos();
	}

	public void modificar(Cliente cliente) {
		// si es preciso aviser al comercial de los cambios
		//
		clienteDao.modificar(cliente);
		
	}
	
	public void borrar(Cliente cliente){
		// avisar comercial de cliente borrado
		// archivo historico de clietes borrar etc 
		clienteDao.borrar(cliente);
		//return cliente.getId();
	}
}
