package interfaces;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import dao.ClienteDAO;
import dao.EstadoDAO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import model.Cliente;
import model.Estado;
import util.CepService;
import util.GeradorCPF;

public class CadastroCliente extends Application{
	
	private TextField cpf,nomeCliente,cep,endereco,nCasa,cidade ,ddd , telCel;
	private ComboBox<String> estado;
	private Button gerarCPF, cadastroCliente , buscaCEP;
	private GridPane gPane;
	  
	public CadastroCliente() {
		cpf = new TextField();
		nomeCliente = new TextField();
		cep = new TextField();
		endereco = new TextField();
		nCasa = new TextField();
		cidade = new TextField();
		
		ddd = new TextField();
		telCel = new TextField();
		
		estado =new ComboBox<String>();
		
		buscaCEP = new Button("Busca CEP");
		
		gerarCPF = new Button("Gerar CPF");
		cadastroCliente = new Button("Cadastrar Cliente");
	
		gPane  = new GridPane();
	}
	
	
	private void configJanela() {
		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.setAlignment(Pos.CENTER);
		
		gPane.add(cpf, 0, 0);
		gPane.add(nomeCliente, 0, 1);
		gPane.add(cep, 0, 2);
		gPane.add(ddd, 0, 3);
		gPane.add(telCel, 0, 4);
		gPane.add(endereco, 0, 5);
		gPane.add(nCasa, 0, 6);
		gPane.add(cidade, 0, 7);
		gPane.add(estado, 0, 8);
		gPane.add(buscaCEP, 1, 2);
		
		carregarEstados();

		cpf.setPromptText("CPF");
		nomeCliente.setPromptText("Nome do Cliente");
		cep.setPromptText("CEP");
		ddd.setPromptText("DDD");
		telCel.setPromptText("telCel");
		endereco.setPromptText("Endereco");
		nCasa.setPromptText("N Casa");
		cidade.setPromptText("Cidade");
		
		
		gPane.add(gerarCPF, 1, 0);
		gPane.add(cadastroCliente, 1, 10);
		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.setPadding(new Insets(10));
		
		
		gerarCPF.setOnAction(e -> {
			String cpf = GeradorCPF.gerarCPF();
			this.cpf.setText(cpf);
		});
		
		cadastroCliente.setOnAction(cad ->{
			Cliente cliente = new Cliente();
			cliente.setCpf(cpf.getText());
			cliente.setNomeCliente(nomeCliente.getText());
			cliente.setCep(cep.getText());
			cliente.setDdd(Integer.parseInt(ddd.getText()));
			cliente.setTelcel(telCel.getText());
			cliente.setEndereco(endereco.getText());
			cliente.setNCasa(Integer.parseInt(nCasa.getText()));
			cliente.setCidade(cidade.getText());
			cliente.setEstado(estado.getValue());
			
			ClienteDAO daClie = new ClienteDAO();
			daClie.salvaCliente(cliente);
			
			System.out.println("Cadastrado Com sucesso");
			
		});
		
		
		buscaCEP.setOnAction(e ->{
			String cepDigitado = cep.getText();
			CepService.buscaCEP(cepDigitado, endereco, cidade, estado,ddd);
		});
		
	}
	
	private void carregarEstados() {
	    EstadoDAO estadoDAO = new EstadoDAO();
	    try {
	        List<String> siglas = estadoDAO.todosOsEstados();
	        //System.out.println("Siglas Carregadas: "+siglas);
	        estado.getItems().addAll(siglas);
	    } catch (Exception e) {
	    	e.printStackTrace();
	   }
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene cenario = new Scene(gPane, 300,600);
		JMetro jMetro = new JMetro(Style.LIGHT);
		
		jMetro.setScene(cenario);
		configJanela();
		primaryStage.setScene(cenario);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
