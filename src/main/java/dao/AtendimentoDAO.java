package dao;

import entities.Atendimento;
import exceptions.PersistenciaJpaException;
import jakarta.persistence.*;
import utility.UtilityManager;

import java.util.List;

public class AtendimentoDAO extends DAO {
    public void save(Atendimento atendimento) throws PersistenceException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            UtilityManager.entityManager.persist(atendimento);
            entityTransaction.commit();
        } catch (PersistenceException e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            throw new PersistenceException(UtilityManager.TEXT_ERROR_PERSISTENCE, e);
        } finally {
            UtilityManager.entityManager.close();
        }

    }

    public Atendimento update(Atendimento atendimento) throws PersistenceException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        Atendimento resultado = atendimento;
        try {
            resultado = UtilityManager.entityManager.merge(atendimento);
            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            throw new PersistenceException(UtilityManager.TEXT_ERROR_PERSISTENCE, e);
        } finally {
            UtilityManager.entityManager.close();
        }
        return resultado;
    }

    public void delete (Atendimento atendimento) throws PersistenciaJpaException{
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            atendimento = UtilityManager.entityManager.find(Atendimento.class, atendimento.getId());
            UtilityManager.entityManager.remove(atendimento);
            entityTransaction.commit();
        }catch (PersistenceException pe) {
            pe.printStackTrace();
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, pe);
        } finally {
            UtilityManager.entityManager.close();
        }
    }
    public Atendimento getByID(int atendimentoId) throws PersistenciaJpaException {
        Atendimento resultado = null;
        try {
            resultado = UtilityManager.entityManager.find(Atendimento.class, atendimentoId);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, pe);
        } finally {
            UtilityManager.entityManager.close();
        }
        return resultado;
    }
    public List<Atendimento> getAlList() throws PersistenciaJpaException{
        List<Atendimento> resAtendimentos = null;
        try {
            TypedQuery<Atendimento> query = UtilityManager.entityManager.createQuery(UtilityManager.TEXT_JDBC_ATENDIMENTO, Atendimento.class );
            resAtendimentos = query.getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, e);
        }finally {
            UtilityManager.entityManager.close();
        }
        return resAtendimentos;
    }

}
