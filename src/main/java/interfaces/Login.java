package interfaces;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import dao.UsuarioSenhaDAO;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

public class Login	extends Application {

	
	private GridPane login;
	private TextField usuario;
	private PasswordField senha;
	private Button entrar;
	
	public Login() {
		login = new GridPane();
		
		usuario = new TextField();
		
		senha = new  PasswordField();
		
		entrar = new Button("Entrar");
	}
	
	
	private void montarJanela() {
		login.setVgap(10);
		login.setHgap(10);
		login.setAlignment(Pos.CENTER);
		login.add(usuario, 0, 0);
		login.add(senha, 0, 1);
	
		usuario.setPromptText("Usuario");
		senha.setPromptText("Senha");
		
		login.add(entrar, 0, 2);
		
		entrar.setOnAction(login ->{
			String usuarioLogin = usuario.getText();
			String senhaLogin = senha.getText();
			
			UsuarioSenhaDAO usuSenha = new UsuarioSenhaDAO();
			
			if(usuSenha.autenticaCliente(usuarioLogin, senhaLogin)) {
				
			}
		});
		
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene cenario = new Scene(login,200,200);
		JMetro jMetro = new JMetro(Style.LIGHT);
		jMetro.setScene(cenario);
		montarJanela();
		primaryStage.setScene(cenario);
		primaryStage.show();
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
