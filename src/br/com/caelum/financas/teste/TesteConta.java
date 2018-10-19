package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {

		Conta conta = new Conta();

		conta.setTitular("p");
		conta.setBanco("C");
		conta.setAgencia("q");
		conta.setConta("q");

		// Essa é a classe principal para gerenciar as entidades e todas as operações
		EntityManager em = new JPAUtil().getEntityManager();

		// Inicia uma trasação
		em.getTransaction().begin();
		em.persist(conta);
		// Persiste o dado
		em.getTransaction().commit();
		// Encerra
		em.close();

		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();

		conta.setTitular("Leonardo");
		// Transforma a conta em managed novamente, pois ela já foi encerrada anteriormente.
		em2.merge(conta);

		em2.getTransaction().commit();
		em2.close();

	}

}
