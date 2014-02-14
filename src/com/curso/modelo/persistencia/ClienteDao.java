package com.curso.modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Cliente;

public class ClienteDao {
	public void insertar(Cliente cliente){
		
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			
			//Usar statement: golpe de remo
			//Statement st = cx.createStatement();
			//st.executeUpdate("insert into cliente (nombre,direccion,telefono) values ('"+cliente.getNombre()+"','"+cliente.getDireccion()+"','"+cliente.getTelefono()+"')");
			//Statement st = cx.createStatement();
			//st.executeUpdate("select * from usuario where login='"+login+"' and pw='"+pw+"'");
			
			PreparedStatement pst = cx.prepareStatement("insert into cliente (NOMBRE, DIRECCION, TELEFONO) values (?,?,?)");
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getDireccion());
			pst.setString(3, cliente.getTelefono());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void modificar(Cliente cliente){
		
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			
			PreparedStatement pst = cx.prepareStatement("update cliente set NOMBRE=?, DIRECCION=?, TELEFONO=? where ID=?");
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getDireccion());
			pst.setString(3, cliente.getTelefono());
			pst.setInt(4, cliente.getId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void borrar(Cliente cliente){
		
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			
			PreparedStatement pst = cx.prepareStatement("delete from cliente where ID=?");
			pst.setInt(1, cliente.getId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Cliente buscar(int id){
		
		Cliente cAux = null;
		
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			
			PreparedStatement pst = cx.prepareStatement("select * from cliente where ID=?");
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				cAux = new Cliente(rs.getInt("ID"),
								   rs.getString("NOMBRE"),
								   rs.getString("DIRECCION"),
								   rs.getString("TELEFONO"));
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cAux;
	}
	
	
	public List<Cliente> listarTodos(){
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			
			PreparedStatement pst = cx.prepareStatement("select * from cliente");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Cliente cAux = new Cliente(rs.getInt("ID"),
						rs.getString("NOMBRE"),
						rs.getString("DIRECCION"),
						rs.getString("TELEFONO"));
				clientes.add(cAux);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return clientes;
	}
}
