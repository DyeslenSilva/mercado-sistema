package interfaces;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RealizaCompra extends Application {
	
	private TextField cpf, nomeCliente, codigoProduto,marcaProduto, precoProduto;
	private TextField qtdeComprada, precoUnidade, precoTotalCompraProduto;
	private Button consultaCPF, consultaCodigoProduto, realizarCompra;
	
	public RealizaCompra() {
		cpf = new TextField();
		nomeCliente = new TextField();
		codigoProduto = new TextField();
		marcaProduto = new TextField();
		precoProduto = new TextField();
		qtdeComprada = new TextField();
		precoProduto = new TextField();
		precoTotalCompraProduto = new TextField();
		
		consultaCodigoProduto = new Button("Consulta Codigo do Produto");
		consultaCPF = new Button("Consulta CPF");
		realizarCompra = new Button("Realizar Compra");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
