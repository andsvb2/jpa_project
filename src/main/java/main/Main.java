package main;

import dao.FuncionarioDAO;
import entities.EnderecoFuncionario;
import entities.Funcionario;
import enums.TipoFuncionario;
import exceptions.JpaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws JpaException {

        FuncionarioDAO funcDAO = new FuncionarioDAO();

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
        } finally {
            funcDAO.close();
        }





    }
}
