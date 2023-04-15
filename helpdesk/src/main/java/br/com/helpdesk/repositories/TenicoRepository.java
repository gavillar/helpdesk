package br.com.helpdesk.repositories;

import br.com.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TenicoRepository extends JpaRepository<Tecnico, Integer> {

}
