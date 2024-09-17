package br.edu.infnet.transportepetfriends.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String rua;
    private int numero;
    private String complemento;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
}
