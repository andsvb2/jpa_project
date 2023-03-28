package dao;

import entities.ClienteTelefone;
import exceptions.PersistenciaJpaException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import utility.UtilityManager;

import java.util.List;

public class ClienteTelefoneDAO extends DAO{
    public ClienteTelefone update(ClienteTelefone cliente) throws PersistenceException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        ClienteTelefone resultado = cliente;
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

    public void delete (ClienteTelefone clienteTelefone) throws PersistenciaJpaException {
        EntityTransaction entityTransaction = UtilityManager.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            clienteTelefone = UtilityManager.entityManager.find(ClienteTelefone.class, clienteTelefone.getId());
            UtilityManager.entityManager.remove(clienteTelefone);
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
    public ClienteTelefone getByID(int clienteId) throws PersistenciaJpaException {
        ClienteTelefone resultado = null;
        try {
            resultado = UtilityManager.entityManager.find(ClienteTelefone.class, clienteId);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaJpaException(UtilityManager.TEXT_ERROR_PERSISTENCE, pe);
        } finally {
            UtilityManager.entityManager.close();
        }
        return resultado;
    }
    public List<ClienteTelefone> getAlList() throws PersistenciaJpaException{
        List<ClienteTelefone> resClintes = null;
        try {
            TypedQuery<ClienteTelefone> query = UtilityManager.entityManager.createQuery(UtilityManager.TEXT_JDBC_CLIENTE_TELEFONE, ClienteTelefone.class );
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
