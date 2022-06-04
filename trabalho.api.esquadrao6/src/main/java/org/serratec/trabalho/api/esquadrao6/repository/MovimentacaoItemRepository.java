package org.serratec.trabalho.api.esquadrao6.repository;

import org.serratec.trabalho.api.esquadrao6.dto.RelatorioDTO;
import org.serratec.trabalho.api.esquadrao6.model.MovimentacaoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacaoItemRepository extends JpaRepository<MovimentacaoItem, Integer> {

    @Query(value =
            "SELECT \n" +
                    "p.produto_nome AS produtoNome,\n" +
                    "SUM(mi.mov_item_qt) AS movimentacaoTotal,\n" +
                    "SUM(mov_item_qt *  mov_item_vl_unit) AS valorTotal\n" +
                    "FROM\n" +
                    "movimentacao_item mi \n" +
                    "JOIN produto p ON mi.produto_id = p.produto_id\n" +
                    "WHERE\n" +
                    "mi.mov_tipo = UPPER('VENDA')\n" +
                    "GROUP BY p.produto_nome \n" +
                    "ORDER BY SUM(mi.mov_item_qt) DESC \n" +
                    "LIMIT 5\n",
            nativeQuery = true)
    List<RelatorioDTO> relatorioProdutosMaisVendidos();

}