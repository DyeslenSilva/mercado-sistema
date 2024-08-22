package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Estado;

public class EstadoDAO {
   
	private static final String perUnit = "mercado-sistema";
    private static EntityManagerFactory factory;
    private static EntityManager entMan; 
    
    public EstadoDAO() {
    	factory = Persistence.createEntityManagerFactory(perUnit);
    	entMan = factory.createEntityManager();
    }
    
    public List<String> todosOsEstados() {
        TypedQuery<String> estados = entMan.createQuery("SELECT e.sigla FROM Estado e", String.class);
        List<String> siglas = estados.getResultList();
        entMan.close(); // Fechando o EntityManager
        return siglas;
    }

}
