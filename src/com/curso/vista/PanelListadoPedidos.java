package com.curso.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.GestorPedidos;

public class PanelListadoPedidos extends VBox {

	private GestorPedidos gestorPedidos = new GestorPedidos();
	
	private FlowPane botonera;
	private ScrollPane panelTabla;
	private Button btnNuevo;
	private TableView<Pedido> tablaPedidos;
	public PanelListadoPedidos() {
		super();
		inicilizar();
		rellenarTablaPedidos();
	}

	private void inicilizar(){
		botonera = new FlowPane();
		btnNuevo = new Button();
		btnNuevo.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				nuevo();
				
			}

		});
		botonera.getChildren().add(btnNuevo);
		
		
	}
	private void rellenarTablaPedidos(){
		
		
		
	}
	
	private void nuevo() {

		
		
	
	}
	
}
