package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
		
		@Id
		private String cpf;
		
		@Column
		private String nomeCliente;
		
		@Column
		private String cep;
		
		@Column
		private int ddd;
		
		@Column
		private String telcel;
		
		@Column
		private String endereco;

		@Column
		private int nCasa;

		@Column
		private String cidade;

		@Column
		private String estado;
}
