package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "estados")
public class Estado {

	@Id
	private String sigla;
	private String estado;
	
}
