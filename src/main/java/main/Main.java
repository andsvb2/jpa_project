package main;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import entities.*;
import enums.TipoFuncionario;
import enums.TipoTelefone;
import exceptions.JpaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Main {
    public static void main(String[] args) throws JpaException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        try {

            EnderecoFuncionario endFunc = new EnderecoFuncionario();
            endFunc.setBairro("Liberdade");
            endFunc.setLogradouro("Rua da Paz");
            endFunc.setNumero("56A");
            endFunc.setComplemento("Térreo");
            endFunc.setCep("89875-096");

            FuncionarioTelefone funTel = new FuncionarioTelefone();
            funTel.setDdd(83);
            funTel.setTelefone(567);
            funTel.setTipo(TipoTelefone.CELULAR);

            Funcionario func1 = new Funcionario();
            func1.setNome("João");
            func1.setSobrenome("Almeida");
            func1.setTipo(TipoFuncionario.CAIXA);
            func1.setEndereco(endFunc);
            func1.setTelefone(funTel);

            Funcionario func2 = new Funcionario();
            func2.setNome("Maria");
            func2.setSobrenome("Albuquerque");
            func2.setTipo(TipoFuncionario.GERENTE);

            EnderecoCliente endCliente = new EnderecoCliente();
            endCliente.setBairro("Anjo da Guarda");
            endCliente.setCep("11111-001");
            endCliente.setComplemento("Subesquina");
            endCliente.setNumero("376");
            endCliente.setLogradouro("Travessa da Esperança");

            Cliente cliente1 = new Cliente();
            cliente1.setEnderecoCliente(endCliente);
            cliente1.setDebitos(950.00);
            cliente1.setNome("Martins");
            cliente1.setSobrenome("Luther");

            em.getTransaction().begin();
            em.persist(endFunc);
            em.persist(funTel);
            em.persist(func1);
            em.persist(func2);
            em.persist(endCliente);
            em.persist(cliente1);
            em.getTransaction().commit();
            em.close();

        } finally {
            em.close();
            System.out.println("Terminou!");
        }





    }
}
