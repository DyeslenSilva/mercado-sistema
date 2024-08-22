package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Cliente;

public class ClienteDAO {

    private static final String PERSISTENCE_UNIT_NAME = "mercado-sistema";
    private static EntityManagerFactory factory;
    private static EntityManager em;
    
    public ClienteDAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }

    public void salvaCliente(Cliente cliente) {
    	em.getTransaction().begin();
    	em.persist(cliente);
    	em.getTransaction().commit();
    }
    
    public Cliente consultaClientePorCPF(String cpf) {
        Cliente cliente = null;
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class);
            query.setParameter("cpf", cpf);
            cliente = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        }
        return cliente;
    }

	
}
