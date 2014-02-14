package com.curso.vista;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;

public class PanelPedidos extends BorderPane{
	
	// objetos de negocio
	private GestorClientes gestorClientes = new GestorClientes();
	
	
	
	// Componentes
	private FlowPane botonera;
	private GridPane formularioPedido;
	
	
	// Buttons 
	private Button btnInsertar;
	private Button btnModificar;
	private Button btnBorrar;
	private Button btnCancelar;
	private Button btnAceptar;
	
	// Labels
	private Label lbCodigo;
	private Label lfFecha;
	private Label lbCleinte;
	
	// TextFields
	private TextField tfCodigo;
	private TextField tfFecha;
	
	// ComboBox
	private ComboBox<Cliente> cbCliente;
	
	public PanelPedidos(){
		super();
		inicializar();
	}

	private void inicializar() {
		
		botonera = new FlowPane();
		botonera.setAlignment(Pos.CENTER);
		
		btnInsertar = new Button("Insertar");
		// OnAction es el evento pulsar un boton
		btnInsertar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// aqui mas de una linea no queremos
				insertar();

			}
		});
		btnModificar = new Button("Modificar");
		btnModificar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// En Panel clientes
				modificar();
			}
		});

		btnBorrar = new Button("Borrar");
		btnBorrar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// En Panel clientes
				borrar();
			}
		});

		btnCancelar = new Button("Cancelar");
		btnCancelar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				cancelar();
			}
		});

		botonera.getChildren().addAll(btnInsertar,btnModificar ,btnBorrar ,btnModificar);
		
		// formualario pedido
		formularioPedido = new GridPane(); 
		formularioPedido.setAlignment(Pos.CENTER);
		
		
		lbCodigo = new Label("Codigo");
		lfFecha = new Label("Fecha");
		lbCleinte = new Label("Cliente");
		
		tfCodigo = new TextField();
		tfFecha = new TextField();
		cbCliente = new ComboBox<Cliente>();
		// el combo box 
		
		// estamos en inicilalizar aqui no poblamos el combobox
		// porque seria con los clientes al principio de arrancar la app
	
	}
	
	private void rellenarComboClientes(){
		// pedimos al gerstor la lista de clientes
		List<Cliente> clientes = gestorClientes.listarTodos();
		// pasamos a observable la lista de clientes
		// para meterla en el combobox
		ObservableList<Cliente> clientesOb =
				FXCollections.observableArrayList(clientes);
		// Entregamos la lista de cliente observable al combobox
		cbCliente.getItems().addAll(clientesOb);
	
	}
	
	
	private void insertar(){
		
	}
	private void modificar(){
		
	}
	private void borrar(){
	
	}
	private void cancelar(){
		
	}

	
	
	

}