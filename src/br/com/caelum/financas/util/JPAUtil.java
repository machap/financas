package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//Fabrica que cria a EntiryMagneger, com base na unidade de persistencia do XML
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");

	public EntityManager getEntityManager() {
        return emf.createEntityManager();
   }
}
