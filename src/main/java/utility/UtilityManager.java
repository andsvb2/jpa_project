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
    public final static String TEXT_JDBC_FUNCIONARIO = "FROM Funcionario";
    public final static String TEXT_JDBC_ATENDIMENTO = "FROM Atendimento";
    public final static String TEXT_JDBC_ATENDIMENTO_PK = "FROM data_atendimento";
    public final static String TEXT_JDBC_CLIENTE = "FROM Cliente";
    public final static String TEXT_JDBC_CLIENTE_TELEFONE = "FROM ClienteTelefone";
    public final static String TEXT_JDBC_COMPRA = "FROM Compra";
}
