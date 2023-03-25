package main;

import bd1.entities.ClienteEnderecoEntity;
import bd1.entities.ClienteEntity;
import bd1.entities.ClienteTelefoneEntity;
import enums.TipoTelefone;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ClienteEnderecoEntity clienteEnderecoEntity = new ClienteEnderecoEntity();
        clienteEnderecoEntity.setCep("00000000");
        clienteEnderecoEntity.setBairro("Centro");
        clienteEnderecoEntity.setComplemento("Casa");
        clienteEnderecoEntity.setNumero("00");
        clienteEnderecoEntity.setLogradouro("Aonde haja sol");

        ClienteTelefoneEntity clienteTelefone = new ClienteTelefoneEntity();
        clienteTelefone.setDdd(81);
        clienteTelefone.setTelefone(999999999);
        clienteTelefone.setTipo(TipoTelefone.CELULAR);
        ClienteEntity cliente = new ClienteEntity();
        cliente.setIdEnd(clienteEnderecoEntity.getId());
        cliente.setDebitos(new BigDecimal(566.00));
        cliente.setNome("fulano");
        cliente.setSobrenome("de tal");

        clienteTelefone.setIdCliente(cliente.getId());
        cliente.setIdTelefone(clienteTelefone.getIdCliente());


    }
}
