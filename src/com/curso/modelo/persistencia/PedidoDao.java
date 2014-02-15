package com.curso.modelo.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Pedido;

public class PedidoDao {

	public void insertar(Pedido pedido){
		
		Connection cx = null;
		
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");

			PreparedStatement pst = 
				cx.prepareStatement("insert into pedido (CODIGO,FECHA,FK_ID_CLIENTE) values (?,?,?)");
			pst.setString(1, pedido.getCodigo());
			pst.setDate(2, new Date(pedido.getFecha().getTime())); //Infernal
			// este date es de java.sql
			pst.setInt(3, pedido.getCliente().getId());
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
	
	
	public List<Pedido> listarTodos(){
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		Connection cx = null;
		
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");

			PreparedStatement pst = 
				cx.prepareStatement("select p.ID as ID_PEDIDO, c.ID as ID_CLIENTE, * from pedido as p "+
											 "join cliente as c on p.FK_ID_CLIENTE= c.ID");
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				
				Cliente cAux = new Cliente(rs.getInt("ID_CLIENTE"),
										   rs.getString("NOMBRE"),
										   rs.getString("DIRECCION"),
										   rs.getString("TELEFONO"));
				
				Pedido pAux = new Pedido(rs.getInt("ID_PEDIDO"),
									     rs.getString("CODIGO"),
									     rs.getDate("FECHA"),
									     cAux);
				
				pedidos.add(pAux);
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
		return pedidos;
	}	
	
	
	
	
	
	
	
	
	
}
