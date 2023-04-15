package br.com.helpdesk.repositories;


import br.com.helpdesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
