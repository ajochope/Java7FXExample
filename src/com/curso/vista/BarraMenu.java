package com.curso.vista;

import java.awt.peer.MenuPeer;



import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class BarraMenu extends MenuBar{
	//depende de la opcion String que se pulse en menu
	// selecionamos un Pane a mostrar 
	private Map<String, Pane> paneles; 
	
	public BarraMenu(){
		super();
		inicializarMenu();
		inicializarMapa();
		
		
	}

	private void inicializarMapa() {
		paneles = new HashMap<String, Pane>();
		paneles.put("panelClientes", new PanelClientes());
		paneles.put("panelPedidos", new PanelPedidos());
	}


	private void inicializarMenu() {

		
		// menu pantallas
		Menu menuPantallas = new Menu("Pantallas");
		
		MenuItem miClientes = new MenuItem("Clientes");
		miClientes.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				mostrarPanel("panelClientes");
				
			}
			
			
		});
		MenuItem miPedidos = new MenuItem("Pedidos");
		miPedidos.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				mostrarPanel("panelPedidos");
				
			}
			
			
		});
		
		
		MenuItem miFacturas = new MenuItem("Facturas");
		miFacturas.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				mostrarPanel("panelFacturas");
				
			}
			
			
		});
		
		menuPantallas.getItems().addAll(miClientes,miPedidos,miFacturas);
		
		// menu informes
		Menu menuInformes = new Menu("Informes");
		MenuItem miInformeClientes = new MenuItem("Clientes");
		MenuItem miInformePedidos = new MenuItem("Pedidos");
		MenuItem miInformeFacturas = new MenuItem("Facturas");
		menuInformes.getItems().addAll(miInformeClientes,miInformePedidos,miInformeFacturas);
		
		
		getMenus().addAll(menuPantallas, menuInformes);
	}
	private void mostrarPanel(String nombrePanel){
		// Como no tenemos referencia a al Vbox
		// para manejar las pantallas que se pulsan
		// en el nemu
		// preguntamos por su padre que es Vbox
		// casting porque devuelve nodo
		VBox panelRaiz = (VBox) getParent();
		
		panelRaiz.getChildren().clear();
		// this es el menuPantallas que se vuelve añadir
		panelRaiz.getChildren().add(this);
		// el string que recibo cmo paramentro
		// indica que pantalla es la que se 
		// pulsa en menu
		
		// añadimos al panel que corresponda con el 
		// string que nos pasan por parametro 
		panelRaiz.getChildren().add(paneles.get(nombrePanel));
		
		
	}
	
	
}
