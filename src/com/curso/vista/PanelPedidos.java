package com.curso.vista;

import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

public class PanelPedidos extends BorderPane{


	//
	private Label lbTitulo;
	
	public PanelPedidos(){
		super();
		inicializar();
		
	}

	private void inicializar() {

	
		
		lbTitulo = new Label("Pantalla de Pedidos");
		setCenter(lbTitulo);
		
		
	}
	
	
}
