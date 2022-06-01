package org.serratec.trabalho.api.esquadrao6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoItemRepository extends JpaRepository<MovimentacaoItemRepository, Integer> {
	
}
