package main;

import entities.Funcionario;

import java.util.List;

public class MainList {
    public static void main(String[] args) {
        MainUpdate.entityManager.getTransaction().begin();
        List<Funcionario> funcionarioList = listar();
        for(Funcionario f : funcionarioList)
            System.out.println(f.getNome());

    }
    public static List<Funcionario> listar() {
        String jpql = "FROM Funcionario f";
        return MainUpdate.entityManager.createQuery(jpql, Funcionario.class).getResultList();
    }
}
