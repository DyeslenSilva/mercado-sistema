package dao.teste;

import java.util.List;

import dao.EstadoDAO;
import model.Estado;
import util.GerarUsuario;

public class TesteDAO {
		
	public static void main(String[] args) {
		String usuarioCliente = GerarUsuario.gerarUsuario("69906601124");
			String senhaCliente = GerarUsuario.gerarSenha("69906601124");
			System.out.println("Usuario: "+usuarioCliente);
			System.out.println("Senha: "+senhaCliente);
	}
	

	
	private void estadoTeste() {
		EstadoDAO daoEstado = new  EstadoDAO();
		List<String> estados = daoEstado.todosOsEstados();
			if(estados != null && !estados.isEmpty()) {
				System.out.println("Siglas: "+estados);
			}else {
				System.out.println("BAnco vazio");
			}	
			
	}
	
	
}
