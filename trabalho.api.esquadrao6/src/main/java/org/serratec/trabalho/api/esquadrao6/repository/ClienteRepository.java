package org.serratec.trabalho.api.esquadrao6.repository;

import org.serratec.trabalho.api.esquadrao6.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
