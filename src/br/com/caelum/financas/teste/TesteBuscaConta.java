package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		//conta vai receber todos os dados do banco referente ao id passado.
		Conta conta = em.find(Conta.class, 6);
		
		//conta.setTitular("João Amoedo");
		conta.setBanco("104 - CAIXA ECONOMICA FEDERAL");
		//conta.setAgencia("4376");
		//conta.setConta("12908-0");
		
		em.getTransaction().commit();
		
		//System.out.println("Nome: " + conta.getTitular());
		
		em.close();
	}

}
