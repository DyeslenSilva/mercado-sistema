package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Produto;

public class ProdutoDAO {
		
		private EntityManager em;
		private EntityManagerFactory emf;
	    private static final String PERSISTENCE_UNIT_NAME = "mercado-sistema";
		
	    public ProdutoDAO() {
		    emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    em = emf.createEntityManager();
		}
	    
	    public void cadasatroProduto(Produto produto) {
	    	em.getTransaction().begin();
	    	em.persist(produto);
	    	em.getTransaction().commit();
	    }
}
