package br.com.helpdesk.repositories;

import br.com.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
