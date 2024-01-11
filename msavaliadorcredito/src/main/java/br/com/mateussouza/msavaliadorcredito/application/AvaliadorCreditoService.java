package br.com.mateussouza.msavaliadorcredito.application;

import br.com.mateussouza.msavaliadorcredito.domain.model.DadosCliente;
import br.com.mateussouza.msavaliadorcredito.domain.model.SituacaoCliente;
import br.com.mateussouza.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) {

        ResponseEntity<DadosCliente> dadosClienteResponseEntity =  clientesClient.dadosCliente(cpf);

        return SituacaoCliente
                .builder()
                .cliente(dadosClienteResponseEntity.getBody())
                .build();
    }
}
