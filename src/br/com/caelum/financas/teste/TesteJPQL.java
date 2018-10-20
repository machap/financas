package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);

		// String query = "select m from Movimentacao m where conta_id = 2";
		// String jpql = "select m from Movimentacao m where m.conta.id = 2";

		String jpql = "select m from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo"
				+ " order by m.valor desc";

		Query query = em.createQuery(jpql);
		//São os paremetros passado na query, comparando as entidades.
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Movimentacao> resultados = query.getResultList();

		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
		}

		em.getTransaction().commit();
		em.close();

	}

}
