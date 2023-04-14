package br.com.helpdesk.services;


import br.com.helpdesk.domain.Chamado;
import br.com.helpdesk.domain.Cliente;
import br.com.helpdesk.domain.Tecnico;
import br.com.helpdesk.domain.enums.Perfil;
import br.com.helpdesk.domain.enums.Prioridade;
import br.com.helpdesk.domain.enums.Status;
import br.com.helpdesk.repositories.ChamadoRepository;
import br.com.helpdesk.repositories.ClienteRepository;
import br.com.helpdesk.repositories.TenicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TenicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {

        Tecnico tec1 = new Tecnico(null, "Gabriel Villar",
                "37666549857",
                "gabriel_gomesvillar@hotmail.com",
                "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null,
                "Bianca",
                "44236587807",
                "bianca.bilieri07@gmail.com",
                "123");

        Chamado c1 = new Chamado(null,
                Prioridade.MEDIA,
                Status.ANDAMENTO,
                "Chamado 01",
                "Primeiro Chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));

    }

}
