package main;

import entities.Funcionario;

public class MainDelete {
    public static void main(String[] args) {
        MainUpdate.entityManager.getTransaction().begin();
        Funcionario funcionario = (Funcionario) MainUpdate.searchByID(1);
        MainUpdate.entityManager.remove(funcionario);
        MainUpdate.entityManager.getTransaction().commit();

    }

}
