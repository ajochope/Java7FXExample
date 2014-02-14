package com.curso.vista;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;

public class PanelClientes extends BorderPane {
	// Objetos de negocio
	GestorClientes gestorClientes = new GestorClientes();

	// Paneles
	private FlowPane botonera;
	private GridPane formulario;
	private ScrollPane panelTabla;

	// Etiquetas
	private Label lbNombre;
	private Label lbDireccion;
	private Label lbTelefono;
	private Label lbTitulo;

	// Cajas de etexto
	private TextField tfNombre;
	private TextField tfDireccion;
	private TextField tfTelefono;

	// Botones
	private Button btnInsertar;
	private Button btnModificar;
	private Button btnBorrar;
	private Button btnCancelar;

	// Tablas
	// tiene cierto conocimiento
	// de los datos que muestra
	private TableView<Cliente> tablaClientes;

	public PanelClientes() {
		super();
		inicializar();
		rellenarTabla();
	}

	private void inicializar() {
		// creacion de botones etc y
		// manejador con clase interna anonima

		botonera = new FlowPane();
		botonera.setAlignment(Pos.CENTER);
		botonera.setHgap(5);

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

		botonera.getChildren().add(btnInsertar);
		botonera.getChildren().add(btnModificar);
		botonera.getChildren().add(btnBorrar);
		botonera.getChildren().add(btnCancelar);

		// Lamamos al metodo setTop
		// heradado de BordePane
		// no hace falta ni el this. por lo mismo heredo
		setTop(botonera);

		// Necesitaremos tres cajas de texto y un botón
		// Los elementos se colocan no controlando los pixeles
		// Panel de rejilla organizado en filas y columnas

		formulario = new GridPane();

		// Cojo un panel y le asigno una alineamiento centrado
		formulario.setAlignment(Pos.CENTER);

		// Asignamos la separación vertical y horizantal de las celdas de la
		// rejilla
		formulario.setHgap(10); // Horizontal
		formulario.setVgap(10); // Vertical

		// Padding
		// Espacio entre componentes adyacentes
		// Nada se puede acerca a menos de 25 pixels por los cuatro lados
		formulario.setPadding(new Insets(25, 25, 25, 25));

		// etiquetas
		lbTitulo = new Label("Formulario de Clientes");
		lbNombre = new Label("Nombre");
		lbDireccion = new Label("Dirección");
		lbTelefono = new Label("Teléfono");

		// campos de texto
		tfNombre = new TextField();
		tfDireccion = new TextField();
		tfTelefono = new TextField();

		// Añadi,os las etiquetas
		// y las cajas de texto al GridPane "formulario"
		// titulo, fila,columna
		formulario.add(lbTitulo, 0, 0, 2, 1);
		formulario.add(lbNombre, 0, 1);
		formulario.add(lbDireccion, 0, 2);
		formulario.add(lbTelefono, 0, 3);
		formulario.add(tfNombre, 1, 1);
		formulario.add(tfDireccion, 1, 2);
		formulario.add(tfTelefono, 1, 3);

		// Añadimos el formualario al centro
		setCenter(formulario);

		// decimos la tabla que colummnas tiene
		panelTabla = new ScrollPane();

		// creamos la tabla
		tablaClientes = new TableView<Cliente>();
		tablaClientes.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				seleccionarCliente();
			}

		});

		// creamos las columnas de la tabla
		TableColumn colNombre = new TableColumn("Nombre");
		colNombre.setMinWidth(125);// ancho minimo colummna
		// asignamos a la columna el valor a mostrar sacado de Cliente
		// un valor tipo string usando getNombre()
		colNombre
				.setCellValueFactory(new PropertyValueFactory<Cliente, String>(
						"nombre"));

		TableColumn colDireccion = new TableColumn("Direccion");
		colDireccion.setMinWidth(125);// ancho minimo colummna
		colDireccion
				.setCellValueFactory(new PropertyValueFactory<Cliente, String>(
						"direccion"));

		TableColumn colTelefono = new TableColumn("Telefono");
		colTelefono.setMinWidth(125);// ancho minimo colummna
		colTelefono
				.setCellValueFactory(new PropertyValueFactory<Cliente, String>(
						"telefono"));

		// asignamos las columnas a la tabla
		tablaClientes.getColumns().addAll(colNombre, colDireccion, colTelefono);

		// un solo elemento para este tipo
		panelTabla.setContent(tablaClientes);
		// añadimos
		setBottom(panelTabla);

	}

	protected void cancelar() {
		tfNombre.setText("");
		tfDireccion.setText("");
		tfTelefono.setText("");

	}

	protected void borrar() {
		Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();

		gestorClientes.borrar(cliente);
		rellenarTabla();

	}

	protected void modificar() {

		Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();
		cliente.setNombre(tfNombre.getText());
		cliente.setDireccion(tfNombre.getText());
		cliente.setTelefono(tfTelefono.getText());

		gestorClientes.modificar(cliente);
		rellenarTabla();

	}

	private void rellenarTabla() {
		// pido la lista al gestor de clientes
		List<Cliente> clientes = gestorClientes.listarTodos();
		// Modificamos la lista que nos da el dao la convertimos el observable
		// para que reaccione dinamicamente a los cambios
		// data from DAO are List with ObservableList change this data type
		// 
		ObservableList<Cliente> clientesObs = FXCollections
				.observableArrayList(clientes);
		tablaClientes.setItems(clientesObs);

	}

	protected void insertar() {

		// estos PASOS siempre
		// coger los datos
		// Always the same steps
		// trim clear the string of blank space
		String nombre = tfNombre.getText().trim();
		String direccion = tfDireccion.getText().trim();
		String telefono = tfTelefono.getText().trim();

		// crear objeto del modelo con los datos (entidad)
		// create object with the data
		Cliente cliente = new Cliente(null, nombre, direccion, telefono);

		// In the future validations....
		// Validaciones ....

		// llamada al metodo de negocio adecuado
		gestorClientes.insertar(cliente);
		// si la insercion es Ok vuelvo a rellenar
		// refill table on the view
		rellenarTabla();

	}

	private void seleccionarCliente() {
		// miro en la tabla y veo que cliente de esa tabla se ha seleccionado
		Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();
		tfNombre.setText(cliente.getNombre());
		tfDireccion.setText(cliente.getDireccion());
		tfTelefono.setText(cliente.getTelefono());
	}

}
