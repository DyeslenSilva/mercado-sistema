package interfaces;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dao.ProdutoDAO;
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
import model.Produto;
import util.CodigoProduto;

public class CadastroProdutos extends Application {

	
	private TextField codigoProduto, nomeProduto, marcaProduto;
	private TextField  precoProduto,qtdeEstoque;
	private Button gerarCodigoProduto, cadastrarProduto;
	private GridPane gPane;
	
	public CadastroProdutos() {
		codigoProduto = new TextField();
		nomeProduto = new TextField();
		marcaProduto = new TextField();
		precoProduto = new  TextField();
		qtdeEstoque = new  TextField();
		
		gerarCodigoProduto = new Button("Gerar Codigo do Produto");
		cadastrarProduto = new Button("Cadastrar Produto");
		
		gPane = new GridPane();
	}
	
	
	private void janelaCadastro() {
		gPane.setVgap(10);
		gPane.setHgap(10);
		gPane.setAlignment(Pos.CENTER);
		
		gPane.add(codigoProduto, 0, 0);
		gPane.add(nomeProduto, 0, 1);
		gPane.add(marcaProduto, 0, 2);
		gPane.add(precoProduto, 0, 3);
		gPane.add(qtdeEstoque, 0, 4);
		
		codigoProduto.setPromptText("Codigo do Produto");
		nomeProduto.setPromptText("Nome do Produto");
		marcaProduto.setPromptText("Marca do Produto");
		precoProduto.setPromptText("Preco do Produto");
		qtdeEstoque.setPromptText("Qtde Estoque");
		
		gPane.add(gerarCodigoProduto, 1, 0);
		gPane.add(cadastrarProduto, 1, 6);
		
		gerarCodigoProduto.setOnAction(gcp ->{
			int codigoDoProduto = CodigoProduto.gerarCodigoProduto();
			codigoProduto.setText(Integer.toString(codigoDoProduto));
		});
		
		cadastrarProduto.setOnAction(cp ->{
			Produto produto = new Produto();
			
			produto.setCodProduto(Integer.parseInt(codigoProduto.getText()));
			produto.setNomeProduto(nomeProduto.getText());
			produto.setMarcaProduto(marcaProduto.getText());
			produto.setPrecoProduto(Double.parseDouble(precoProduto.getText()));
			produto.setQtdeEstoque(Integer.parseInt(qtdeEstoque.getText()));
			
			ProdutoDAO daoPro = new ProdutoDAO();
			daoPro.cadasatroProduto(produto);
			
			Stage stage = (Stage) cadastrarProduto.getScene().getWindow();
			stage.close();
			
		});
		
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene cena = new Scene(gPane,400,300);
		JMetro jMetro = new JMetro(Style.LIGHT);
		jMetro.setScene(cena);
			janelaCadastro();
			primaryStage.setScene(cena);
			primaryStage.show();
		}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
