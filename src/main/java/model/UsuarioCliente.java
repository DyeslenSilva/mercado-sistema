package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "usuarioCliente")
@Entity
public class UsuarioCliente {

	
	@Id
	private String usuario;
	
	@Column
	private String senha;
	

}
