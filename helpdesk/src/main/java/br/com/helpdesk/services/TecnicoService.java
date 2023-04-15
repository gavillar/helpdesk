package br.com.helpdesk.services;


import br.com.helpdesk.domain.Tecnico;
import br.com.helpdesk.repositories.TenicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TenicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElse(null);
    }

}
