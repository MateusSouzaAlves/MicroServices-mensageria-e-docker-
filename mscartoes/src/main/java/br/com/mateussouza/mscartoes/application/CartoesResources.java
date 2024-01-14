package br.com.mateussouza.mscartoes.application;

import br.com.mateussouza.mscartoes.application.representation.CartaoSaveRequest;
import br.com.mateussouza.mscartoes.application.representation.CartoesPorClienteResponse;
import br.com.mateussouza.mscartoes.domain.Cartao;
import br.com.mateussouza.mscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesResources {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){

        return "ok";
    }

    @PostMapping
    public ResponseEntity<CartaoSaveRequest> cadastra(@RequestBody CartaoSaveRequest request) {
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
       List<ClienteCartao> lista = clienteCartaoService.listCartoesByCpf(cpf);
       List<CartoesPorClienteResponse> resultList = lista.stream().map(CartoesPorClienteResponse::fromModel).collect(Collectors.toList());
       return ResponseEntity.ok(resultList);
    }
}
