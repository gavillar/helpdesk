package br.com.helpdesk.repositories;


import br.com.helpdesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
