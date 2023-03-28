package main;

import entities.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainUpdate {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        Funcionario funcionario = (Funcionario) searchByID(1);
        funcionario.setNome("Carl");
        entityManager.getTransaction().begin();
        entityManager.merge(funcionario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Object searchByID(Integer id){
        //usar a classe que deseja procurar, nesse caso Funcionario
       return entityManager.find(Funcionario.class, id);
    }
}
