package br.com.helpdesk.repositories;

import br.com.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenicoRepository extends JpaRepository<Tecnico, Integer> {
}
