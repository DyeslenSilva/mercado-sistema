package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "produto")
@Entity
public class Produto {

	@Id
	private int codProduto;
	
	@Column
	private String nomeProduto;
	
	@Column
	private String marcaProduto;
	
	@Column
	private double precoProduto;
	
	@Column
	private int qtdeEstoque;
	
}
