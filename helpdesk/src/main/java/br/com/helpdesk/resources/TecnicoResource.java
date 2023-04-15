package br.com.helpdesk.resources;

import br.com.helpdesk.domain.Tecnico;
import br.com.helpdesk.domain.dtos.TecnicoDTO;
import br.com.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

// Essa classe representa um recurso REST que lida com requisições relacionadas a técnicos em um sistema de helpdesk.
// A anotação @RestController indica que a classe é um controlador REST, e a anotação @RequestMapping mapeia as requisições para o caminho "/tecnicos".
// O método findById é anotado com @GetMapping e mapeia as requisições HTTP GET para o caminho "/tecnicos/{id}",
// onde {id} é um parâmetro de caminho que representa o ID do técnico a ser retornado.
// O método chama o método findById do serviço TecnicoService para obter o objeto Tecnico correspondente ao ID fornecido e,
// em seguida, retorna uma resposta HTTP com o objeto TecnicoDTO correspondente no corpo da resposta.
// TecnicoDTO é uma classe DTO (Data Transfer Object) que representa um técnico e seus atributos em um formato mais adequado para a transferência de dados,
// geralmente para fins de comunicação com o cliente de um serviço.
// TecnicoService é uma classe de serviço que fornece métodos para lidar com a lógica de negócios relacionada a técnicos,
// como encontrar técnicos por ID ou atualizar suas informações.
// A anotação @Autowired é usada para injetar uma instância de TecnicoService na classe TecnicoResource.

@RestController
// Quando não conter nenhum parâmetro após o "/tecnicos", será chamado o findAll().
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {


    //Instância
    @Autowired
    private TecnicoService service;

    //EndPoint findById
    @GetMapping(value = "{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        Tecnico obj = service.findById(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    //EndPoint findAll
    @GetMapping
    private ResponseEntity<List<TecnicoDTO>> findAll() {
        List<Tecnico> list = service.findAll();
        List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO()).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDTO) {
        Tecnico newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

}
