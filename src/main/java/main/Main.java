package main;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import entities.Cliente;
import entities.EnderecoCliente;
import entities.EnderecoFuncionario;
import entities.Funcionario;
import enums.TipoFuncionario;
import exceptions.JpaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JpaException {

        FuncionarioDAO funcDAO = new FuncionarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
            EntityManager em = emf.createEntityManager();

            EnderecoFuncionario endFunc = new EnderecoFuncionario();
            endFunc.setBairro("Liberdade");
            endFunc.setLogradouro("Rua da Paz");
            endFunc.setNumero("56A");
            endFunc.setComplemento("Térreo");
            endFunc.setCep("89875-096");

            Funcionario func1 = new Funcionario();
            func1.setNome("João");
            func1.setSobrenome("Almeida");
            func1.setTipo(TipoFuncionario.CAIXA);
            func1.setEndereco(endFunc);
            funcDAO.save(func1);

            List<EnderecoCliente> enderecosCliente = new ArrayList<>();
            EnderecoCliente endCliente = new EnderecoCliente();
            endCliente.setBairro("Anjo da Guarda");
            endCliente.setCep("11111-001");
            endCliente.setComplemento("Subesquina");
            endCliente.setNumero("376");
            endCliente.setLogradouro("Travessa da Esperança");
            enderecosCliente.add(endCliente);

            EnderecoCliente endCliente1 = new EnderecoCliente();
            endCliente1.setLogradouro("Avenida Bacanga");
            endCliente1.setNumero("35-B");
            endCliente1.setCep("00000-110");
            endCliente1.setBairro("Areinha");
            endCliente1.setComplemento("Oficina D+");
            enderecosCliente.add(endCliente1);

            Cliente cliente1 = new Cliente();
            cliente1.setEnderecosCliente(enderecosCliente);
            cliente1.setDebitos(950.00);
            cliente1.setNome("Martins");
            cliente1.setSobrenome("Luther");
            clienteDAO.save(cliente1);
        } finally {
            funcDAO.close();
        }





    }
}
