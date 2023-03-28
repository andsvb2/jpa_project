package dao;

import entities.Cliente;
import exceptions.PersistenciaJpaException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import utility.UtilityManager;

import java.util.List;

public class ClienteDAO extends DAO{

    public Cliente update(Cliente cliente) throws PersistenceException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        Cliente resultado = cliente;
        try {
            resultado = UtilityManager.entityManager.merge(cliente);
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

    public void delete (Cliente cliente) throws PersistenciaJpaException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            cliente = UtilityManager.entityManager.find(Cliente.class, cliente.getId());
            UtilityManager.entityManager.remove(cliente);
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
    public Cliente getByID(int clienteId) throws PersistenciaJpaException {
        Cliente resultado = null;
        try {
            resultado = UtilityManager.entityManager.find(Cliente.class, clienteId);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, pe);
        } finally {
            UtilityManager.entityManager.close();
        }
        return resultado;
    }
    public List<Cliente> getAlList() throws PersistenciaJpaException{
        List<Cliente> resClintes = null;
        try {
            TypedQuery<Cliente> query = UtilityManager.entityManager.createQuery(UtilityManager.TEXT_JDBC_CLIENTE, Cliente.class );
            resClintes = query.getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, e);
        }finally {
            UtilityManager.entityManager.close();
        }
        return resClintes;
    }

    public void save(Cliente cliente) throws PersistenceException {
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
