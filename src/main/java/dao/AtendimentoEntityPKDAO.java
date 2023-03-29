package dao;

import entities.AtendimentoEntityPK;
import exceptions.PersistenciaJpaException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import utility.UtilityManager;

import java.util.List;

public class AtendimentoEntityPKDAO extends DAO{
    public AtendimentoEntityPK update(AtendimentoEntityPK atendimentoEntityPK) throws PersistenceException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        AtendimentoEntityPK resultado = atendimentoEntityPK;
        try {
            resultado = UtilityManager.entityManager.merge(atendimentoEntityPK);
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

    public void delete (AtendimentoEntityPK atendimentoEntityPK) throws PersistenciaJpaException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            atendimentoEntityPK = UtilityManager.entityManager.find(AtendimentoEntityPK.class, atendimentoEntityPK.getDataAtendimento());
            UtilityManager.entityManager.remove(atendimentoEntityPK);
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
    public AtendimentoEntityPK getByID(int atendimentoID) throws PersistenciaJpaException {
        AtendimentoEntityPK resultado = null;
        try {
            resultado = UtilityManager.entityManager.find(AtendimentoEntityPK.class, atendimentoID);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, pe);
        } finally {
            UtilityManager.entityManager.close();
        }
        return resultado;
    }
    public List<AtendimentoEntityPK> getAlList() throws PersistenciaJpaException{
        List<AtendimentoEntityPK> resClintes = null;
        try {
            TypedQuery<AtendimentoEntityPK> query = UtilityManager.entityManager.createQuery(UtilityManager.TEXT_JDBC_ATENDIMENTO_PK, AtendimentoEntityPK.class );
            resClintes = query.getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, e);
        }finally {
            UtilityManager.entityManager.close();
        }
        return resClintes;
    }

    public void save() throws PersistenceException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            UtilityManager.entityManager.persist(this);
            entityTransaction.commit();
        } catch (PersistenceException e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            throw new PersistenceException(UtilityManager.TEXT_ERROR_PERSISTENCE, e);
        } finally {
            UtilityManager.entityManager.close();
        }
    }
}
