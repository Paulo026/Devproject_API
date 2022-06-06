package org.serratec.trabalho.api.esquadrao6.repository;

import org.serratec.trabalho.api.esquadrao6.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	@Query(value = "select * from produto where produto_nome = :nomeProduto limit 1", nativeQuery = true)
	Produto recuperarNome(String nomeProduto);

}
