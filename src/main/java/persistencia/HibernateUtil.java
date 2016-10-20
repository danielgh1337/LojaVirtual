package persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			StandardServiceRegistryBuilder registroServico = new StandardServiceRegistryBuilder();
			registroServico.applySettings(cfg.getProperties());
			StandardServiceRegistry servico = registroServico.build();
			
			return cfg.buildSessionFactory(servico);
		} catch (Throwable t) {
			System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + t.getMessage());
			t.printStackTrace();
			throw new ExceptionInInitializerError(t);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
