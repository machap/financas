package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setTitular("Paulo Victor");
		conta.setConta("Caixa Economica");
		conta.setAgencia("123");
		conta.setNumero("456");
		
		//Fabrica que cria a EntiryMagneger, com base na unidade de persistencia do XML
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		//Essa é a classe principal para gerenciar as entidades e todas as operações
		EntityManager em = emf.createEntityManager();
		
		//Inicia uma trasação
		em.getTransaction().begin();
		em.persist(conta);
		//Persiste o dado
		em.getTransaction().commit();
		
		//Encerra 
		em.close();
		emf.close();
	}

}
