package main;

import entities.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Funcionario func1 = new Funcionario();
        func1.setNome("João");
        func1.setSobrenome("Almeida");
        func1.setTipo("Caixa");
//        ClienteEnderecoEntity clienteEnderecoEntity = new ClienteEnderecoEntity();
//        clienteEnderecoEntity.setCep("00000000");
//        clienteEnderecoEntity.setBairro("Centro");
//        clienteEnderecoEntity.setComplemento("Casa");
//        clienteEnderecoEntity.setNumero("00");
//        clienteEnderecoEntity.setLogradouro("Aonde haja sol");

        entityManager.getTransaction().begin();
        entityManager.persist(func1);
        entityManager.getTransaction().commit();
        entityManager.close();
//
//        ClienteTelefoneEntity clienteTelefone = new ClienteTelefoneEntity();
//        clienteTelefone.setDdd(81);
//        clienteTelefone.setTelefone(999999999);
//        clienteTelefone.setTipo(TipoTelefone.CELULAR);
//        ClienteEntity cliente = new ClienteEntity();
//        cliente.setIdEnd(clienteEnderecoEntity.getId());
//        cliente.setDebitos(new BigDecimal(566.00));
//        cliente.setNome("fulano");
//        cliente.setSobrenome("de tal");
//
//        clienteTelefone.setIdCliente(cliente.getId());
//        cliente.setIdTelefone(clienteTelefone.getIdCliente());


    }
}
