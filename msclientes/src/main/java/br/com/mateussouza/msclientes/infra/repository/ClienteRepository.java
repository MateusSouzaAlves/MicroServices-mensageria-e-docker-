package br.com.mateussouza.msclientes.infra.repository;

import br.com.mateussouza.msclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByCPF(String cpf);
}
