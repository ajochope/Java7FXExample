package com.curso.modelo.entidad;

/**
 * @author Mañana
 *
 */
public class Cliente {

	// tengo null valor por defecto en id
	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	
	// (ALT+SHIFT+S) + C : Constructor por defecto
	// (ALT+SHIFT+S) + O : Constructor con parametrod
	// (ALT+SHIFT+S) + R : Get/ Set
	// (ALT+SHIFT+S) + S : toString
	
	@Override
	public String toString() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Cliente(Integer id, String nombre, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
