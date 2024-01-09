package br.com.mateussouza.msclientes.application;

import br.com.mateussouza.msclientes.application.representation.ClienteSaveRequestDTO;
import br.com.mateussouza.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@Slf4j
public class ClientesResources {

    private final ClienteService service;

    @GetMapping
    public String status() {
        log.info("Obtendo o status do microservice de CLientes");
        return "ok";
    }

    @PostMapping
    public ResponseEntity<ClienteSaveRequestDTO> save(@RequestBody ClienteSaveRequestDTO request){
        Cliente cliente = request.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){
        var cliente = service.getByCPF(cpf);
        if (cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
    
}
