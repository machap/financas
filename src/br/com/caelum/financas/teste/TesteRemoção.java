package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteRemoção {

	public static void main(String[] args) {
		
		Conta conta = new Conta();

		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();

		conta = em.find(Conta.class, 7);
		
		em.remove(conta);

		em.getTransaction().commit();
		
		em.close();

	}

}
