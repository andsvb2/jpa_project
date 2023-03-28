package main;

import entities.EnderecoFuncionario;
import entities.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EnderecoFuncionario endFunc = new EnderecoFuncionario();
        endFunc.setBairro("Liberdade");
        endFunc.setLogradouro("Rua da Paz");
        endFunc.setNumero("56A");
        endFunc.setComplemento("Térreo");
        endFunc.setCep("89875-096");

        Funcionario func1 = new Funcionario();
        func1.setNome("João");
        func1.setSobrenome("Almeida");
        func1.setTipo("Caixa");
        func1.setEndereco(endFunc);

        entityManager.getTransaction().begin();
        entityManager.persist(endFunc);
        entityManager.persist(func1);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
