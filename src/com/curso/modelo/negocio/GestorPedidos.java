package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.persistencia.PedidoDao;

public class GestorPedidos {

	private PedidoDao pedidoDao = new PedidoDao();
	
	public void insertar(Pedido pedido){
		pedidoDao.insertar(pedido);
	}
	
	public List<Pedido> listarTodos(){
		return pedidoDao.listarTodos();
	}
	
}
