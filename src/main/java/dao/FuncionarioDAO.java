package dao;

import entities.Funcionario;
import exceptions.PersistenciaJpaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import utility.UtilityManager;

import java.util.List;

public class FuncionarioDAO  extends DAO {

    public void save(Funcionario funcionario) throws PersistenciaJpaException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(funcionario);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, pe);
        } finally {
            em.close();
        }
    }

    public Funcionario update(Funcionario funcionario) throws PersistenciaJpaException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Funcionario resultado = funcionario;
        try {
            resultado = em.merge(funcionario);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, pe);
        } finally {
            em.close();
        }
        return resultado;
    }

    public void delete(Funcionario funcionario) throws PersistenciaJpaException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            funcionario = em.find(Funcionario.class, funcionario.getId());
            em.remove(funcionario);
            transaction.commit();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenciaJpaException("Ocorreu algum erro ao tentar remover o usuário.", pe);
        } finally {
            em.close();
        }
    }

    public Funcionario getByID(int funcionarioId) throws PersistenciaJpaException {
        EntityManager em = getEntityManager();
        Funcionario resultado = null;
        try {
            resultado = em.find(Funcionario.class, funcionarioId);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaJpaException("Ocorreu algum erro ao tentar recuperar o usuário com base no ID.", pe);
        } finally {
            em.close();
        }
        return resultado;
    }

    public List<Funcionario> getAll() throws PersistenciaJpaException {
        EntityManager em = getEntityManager();
        List<Funcionario> resultado = null;
        try {
            TypedQuery<Funcionario> query = em.createQuery(UtilityManager.TEXT_JDBC_FUNCIONARIO, Funcionario.class);
            resultado = query.getResultList();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaJpaException("Ocorreu algum erro ao tentar recuperar todos os usuários.", pe);
        } finally {
            em.close();
        }
        return resultado;
    }

}
