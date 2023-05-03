package br.com.helpdesk.resources;

import br.com.helpdesk.domain.Cliente;
import br.com.helpdesk.domain.dtos.ClienteDTO;
import br.com.helpdesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

// Essa classe representa um recurso REST que lida com requisições relacionadas a técnicos em um sistema de helpdesk.
// A anotação @RestController indica que a classe é um controlador REST, e a anotação @RequestMapping mapeia as requisições para o caminho "/tecnicos".
// O método findById é anotado com @GetMapping e mapeia as requisições HTTP GET para o caminho "/tecnicos/{id}",
// onde {id} é um parâmetro de caminho que representa o ID do técnico a ser retornado.
// O método chama o método findById do serviço ClienteService para obter o objeto Cliente correspondente ao ID fornecido e,
// em seguida, retorna uma resposta HTTP com o objeto ClienteDTO correspondente no corpo da resposta.
// ClienteDTO é uma classe DTO (Data Transfer Object) que representa um técnico e seus atributos em um formato mais adequado para a transferência de dados,
// geralmente para fins de comunicação com o cliente de um serviço.
// ClienteService é uma classe de serviço que fornece métodos para lidar com a lógica de negócios relacionada a técnicos,
// como encontrar técnicos por ID ou atualizar suas informações.
// A anotação @Autowired é usada para injetar uma instância de ClienteService na classe ClienteResource.

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {


    //Instância
    @Autowired
    private ClienteService service;

    //EndPoint findById
    @GetMapping(value = "{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        Cliente obj = service.findById(id);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }

    //EndPoint findAll
    @GetMapping
    private ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> list = service.findAll();
        List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO()).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objDTO) {
        Cliente newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDTO) {
        Cliente obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
