package br.com.mateussouza.mscartoes.application.representation;

import br.com.mateussouza.mscartoes.domain.BandeiraCartao;
import br.com.mateussouza.mscartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBase;

    public Cartao toModel(){
        return new Cartao(nome,bandeira,renda,limiteBase);
    }
}
