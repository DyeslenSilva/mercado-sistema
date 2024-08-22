package util;

import dao.ClienteDAO;
import model.Cliente;

public class GerarUsuario {

	private static ClienteDAO clienteDAO = new ClienteDAO();
	private Cliente cliente;
	
	
	public GerarUsuario(ClienteDAO clienteDAO) {
		GerarUsuario.clienteDAO = clienteDAO;
	}
	
	
	public static String gerarUsuario(String cpf) {
		Cliente cliente = clienteDAO.consultaClientePorCPF(cpf);
		
		if(cliente != null) {
			String parteCPF = cpf.substring(0,3);
			String nomeParte = cliente.getNomeCliente().substring(0,3).toLowerCase();
			return parteCPF + nomeParte;
		}
		return null;
	}
	
	
	public static String gerarSenha(String cpf) {
		Cliente cliente  = clienteDAO.consultaClientePorCPF(cpf);
		
		if(cliente !=null) {
			String parteTelCel = cliente.getTelcel().substring(1, 4);
			int nCasa = cliente.getNCasa();
			String senha = parteTelCel + nCasa;
			return senha;
		}
		return null;
	}
	
	
	
}
