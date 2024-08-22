package interfaces;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

public class LoginII extends Application{

	private GridPane loginJanela;
	private TextField login;
	private PasswordField senha;
	private Button entrar;
	
	public LoginII() {
		loginJanela = new GridPane();
		
		login = new TextField();
		senha = new PasswordField();
		
		entrar = new Button("Entrar");
	}
	
	private void janela() {
		loginJanela.add(login, 0, 0);
		loginJanela.add(senha, 0, 1);
		loginJanela.add(entrar, 0, 2);
		
		loginJanela.setAlignment(Pos.CENTER);
		loginJanela.setVgap(10);
		loginJanela.setHgap(10);
		loginJanela.setPadding(new Insets(10));
		
		
		login.setPromptText("Login");
		senha.setPromptText("Senha");	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene cena = new Scene(loginJanela,300,200);
		
		JMetro metro = new JMetro(Style.LIGHT);
		metro.setScene(cena);
		
		janela();
		primaryStage.setScene(cena);
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
	
}
