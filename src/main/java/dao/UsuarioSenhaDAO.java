package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Cliente;
import model.UsuarioCliente;
import util.GerarUsuario;

public class UsuarioSenhaDAO {

    private static final String perUnit = "mercado-sistema";
    private static EntityManagerFactory factory;
    private static EntityManager entMan;

    private ClienteDAO clienteDAO;

    public UsuarioSenhaDAO() {
        factory = Persistence.createEntityManagerFactory(perUnit);
        entMan = factory.createEntityManager();
        clienteDAO = new ClienteDAO();
    }

    public String criaUsuarioSenha(String usuario, String senha) {
        // Supondo que o usuário e senha sejam gerados corretamente
        if (usuario == null || senha == null || usuario.isEmpty() || senha.isEmpty()) {
            return "Erro ao gerar usuário e senha";
        }

        UsuarioCliente usuCliente = new UsuarioCliente();
        usuCliente.setUsuario(usuario);
        usuCliente.setSenha(senha);

        try {
            entMan.getTransaction().begin();
            entMan.persist(usuCliente);
            entMan.getTransaction().commit();
            return "Usuário cadastrado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao cadastrar usuário.";
        }
    }
    
    public boolean autenticaCliente(String usuario,String senha) {
        TypedQuery<UsuarioCliente> query = entMan.createQuery(
                "SELECT u FROM UsuarioCliente u WHERE u.usuario = :usuario AND u.senha = :senha", UsuarioCliente.class);
        query.setParameter("usuario",usuario);
        query.setParameter("senha",senha);
        return query.getSingleResult() != null;
    }
}
