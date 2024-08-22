package interfaces;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dao.UsuarioSenhaDAO;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import util.GerarUsuario;

public class UsuarioSenha extends Application {

    private GridPane usuarioSenha;
    private TextField cpf, usuario, senha;
    private Button gerarUsuarioSenha, cadastrarUsuario;
    private Alert alertError, successAlert;

    public UsuarioSenha() {
        usuarioSenha = new GridPane();

        cpf = new TextField();
        usuario = new TextField();
        senha = new TextField();

        gerarUsuarioSenha = new Button("Gerar Usuario Senha");
        cadastrarUsuario = new Button("Cadastrar Usuario");

        successAlert = new Alert(AlertType.INFORMATION);
        alertError = new Alert(AlertType.ERROR);
    }

    private void janela() {
    	usuarioSenha.setHgap(10);
    	usuarioSenha.setVgap(10);
    	usuarioSenha.setAlignment(Pos.CENTER);
        usuarioSenha.add(cpf, 0, 0);
        usuarioSenha.add(usuario, 0, 1);
        usuarioSenha.add(senha, 0, 2);

        cpf.setPromptText("CPF");
        usuario.setPromptText("Usuario");
        senha.setPromptText("Senha");

        usuarioSenha.add(gerarUsuarioSenha, 1, 0);
        usuarioSenha.add(cadastrarUsuario, 0, 3);

        gerarUsuarioSenha.setOnAction(gus -> {
            String cpfInput = cpf.getText();

            if (cpfInput != null && !cpfInput.isEmpty()) {

            	String usuarioGerado = GerarUsuario.gerarUsuario(cpfInput);
                String senhaGerada = GerarUsuario.gerarSenha(cpfInput);

                if (usuarioGerado != null && senhaGerada != null) {
                    this.usuario.setText(usuarioGerado);
                    this.senha.setText(senhaGerada);

                    successAlert.setTitle("CPF Encontrado");
                    successAlert.setHeaderText("CPF encontrado");
                    successAlert.setContentText("CPF válido. Usuário e senha gerados.");
                    successAlert.showAndWait();
                } else {
                    alertError.setTitle("Erro de Geração");
                    alertError.setHeaderText("Erro ao gerar usuário e senha");
                    alertError.setContentText("Não foi possível gerar usuário e senha.");
                    alertError.showAndWait();
                }
            } else {
                alertError.setTitle("CPF Inválido");
                alertError.setHeaderText("CPF Inválido");
                alertError.setContentText("Insira um CPF válido.");
                alertError.showAndWait();
            }
        });

        cadastrarUsuario.setOnAction(cusu -> {
            String usu = usuario.getText();
            String sen = senha.getText();

            UsuarioSenhaDAO usuSenhaDAO = new UsuarioSenhaDAO();
            String resultado = usuSenhaDAO.criaUsuarioSenha(usu, sen);

            if (resultado.equals("Usuário cadastrado com sucesso!")) {
                successAlert.setTitle("Sucesso");
                successAlert.setHeaderText("Usuário Cadastrado");
                successAlert.setContentText(resultado);
                successAlert.showAndWait();
            } else {
                alertError.setTitle("Erro");
                alertError.setHeaderText("Erro ao cadastrar usuário");
                alertError.setContentText(resultado);
                alertError.showAndWait();
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene cenario = new Scene(usuarioSenha, 300, 300);
        JMetro jMetro = new JMetro(Style.LIGHT);
        
        jMetro.setScene(cenario);
        
        janela();
        primaryStage.setScene(cenario);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
