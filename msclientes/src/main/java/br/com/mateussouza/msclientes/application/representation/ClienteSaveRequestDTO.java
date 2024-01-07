package br.com.mateussouza.msclientes.application.representation;

import br.com.mateussouza.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequestDTO {
    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel(){
        return new Cliente(cpf,nome,idade);
    }
}
