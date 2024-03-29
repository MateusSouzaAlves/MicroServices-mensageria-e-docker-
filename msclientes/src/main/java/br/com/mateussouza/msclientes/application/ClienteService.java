package br.com.mateussouza.msclientes.application;

import br.com.mateussouza.msclientes.domain.Cliente;
import br.com.mateussouza.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) {

        return repository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){

        return repository.findByCpf(cpf);
    }
}
