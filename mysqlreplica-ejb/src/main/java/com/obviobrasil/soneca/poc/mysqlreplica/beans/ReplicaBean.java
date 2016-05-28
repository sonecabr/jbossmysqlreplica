package com.obviobrasil.soneca.poc.mysqlreplica.beans;

import com.obviobrasil.soneca.poc.mysqlreplica.beans.core.beans.IReplicaBean;
import com.obviobrasil.soneca.poc.mysqlreplica.beans.core.entity.TestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
 * @author andre
 * @since 28/05/2016 11:55
 */
@Stateless
@Remote(IReplicaBean.class)
public class ReplicaBean implements IReplicaBean {

    @PersistenceContext(name = "replicaEm")
    private EntityManager em;

    private Logger LOG = LoggerFactory.getLogger(ReplicaBean.class);

    @Override
    public List<TestEntity> findAll() {
        try {
            LOG.warn("trying get results...");
            Query query = em.createQuery("SELECT m from " + TestEntity.class.getSimpleName() + " m order by m.id desc");
            query.setMaxResults(1000);
            return query.getResultList();
        } catch (NoResultException e){
            LOG.error("Error on aquiring resultset", e);
        } finally {}

        return null;
    }

    @Override
    public TestEntity save(TestEntity entity) {
        if(em.contains(entity)){
            createOrUpdate(entity);
        } else {
            entity = merge(entity);
        }
        return entity;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    private void createOrUpdate(TestEntity entity){
        em.persist(entity);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    private TestEntity merge(TestEntity entity){
        return em.merge(entity);
    }
}
