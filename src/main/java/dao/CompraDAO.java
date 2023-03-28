package dao;

import entities.Cliente;
import entities.Compra;
import exceptions.PersistenciaJpaException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import utility.UtilityManager;

import java.util.List;

public class CompraDAO extends DAO {
    public Compra update(Compra compra) throws PersistenceException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        Compra resultado = compra;
        try {
            resultado = UtilityManager.entityManager.merge(compra);
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

    public void delete (Compra compra) throws PersistenciaJpaException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            compra = UtilityManager.entityManager.find(Compra.class, compra.getId());
            UtilityManager.entityManager.remove(compra);
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
    public Compra getByID(int compraid) throws PersistenciaJpaException {
        Compra resultado = null;
        try {
            resultado = UtilityManager.entityManager.find(Compra.class, compraid);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, pe);
        } finally {
            UtilityManager.entityManager.close();
        }
        return resultado;
    }
    public List<Compra> getAlList() throws PersistenciaJpaException{
        List<Compra> resCompras = null;
        try {
            TypedQuery<Compra> query = UtilityManager.entityManager.createQuery(UtilityManager.TEXT_JDBC_COMPRA, Compra.class );
            resCompras = query.getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, e);
        }finally {
            UtilityManager.entityManager.close();
        }
        return resCompras;
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
