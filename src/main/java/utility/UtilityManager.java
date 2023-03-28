package utility;

import entities.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import main.MainUpdate;

import java.util.List;

public class UtilityManager {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public final static String TEXT_ERROR_PERSISTENCE = "Ocorreu algum erro ao tentar salvar o usuário.";
    public final static String TEXT_JDBC_FUNCIONARIO = "FROM Funcionarios";
    public final static String TEXT_JDBC_ATENDIMENTO = "FROM Atendimento";
}
