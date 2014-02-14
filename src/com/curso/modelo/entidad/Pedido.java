package com.curso.modelo.entidad;

import java.util.Date;

public class Pedido {

	private Integer id;
	private String codigo;
	private Date fecha;
	
	// (ALT+SHIFT+S) + C : Constructor por defecto
	// (ALT+SHIFT+S) + O : Constructor con parametros
	// (ALT+SHIFT+S) + R : Get/ Set
	// (ALT+SHIFT+S) + S : toString
	
	
	// composicion de objetos
	private Cliente cliente;
	// dentro del pedido tenemos datos sobre el
	// pedido y una referencia al cliente 
	// que trata el pedido

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", codigo=" + codigo + ", fecha=" + fecha
				+ ", cliente=" + cliente + "]";
	}
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pedido(Integer id, String codigo, Date fecha, Cliente cliente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
