package testeconn;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteConnJPA {
			
	private EntityManagerFactory emf = null;
	private EntityManager em =null;
	
	private final String perUnitName = "mercado-sistema";
	
	public TesteConnJPA() {
		emf = Persistence.createEntityManagerFactory(perUnitName);
		em = emf.createEntityManager();
	}
	
	public void testConn() throws Exception{
		em.getTransaction().begin();
		System.out.println("Conexao bem sucedida");
		em.getTransaction().commit();
	}
	
	
	public static void main(String[] args) throws Exception {
		TesteConnJPA conn = new TesteConnJPA();
		conn.testConn();
	}
}
