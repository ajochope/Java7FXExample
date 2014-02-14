package application;
	
import com.curso.vista.BarraMenu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// metodo start que recibe un escenario

			// creamos un panel vbox
			// organiza os elementos en la unica columna
			VBox vbox = new VBox();
			// añadimos la barramenu
			vbox.getChildren().add(new BarraMenu());
			
			// creamos la escena con vbox 
			// como panel principal
			Scene scene = new Scene(vbox,450,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// el nombre del driver debemos 
		//conseguirlo de un fichero externo
		// desacoplamos el pgm de la bbdd Mysql
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args);
	}
}
