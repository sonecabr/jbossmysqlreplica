package com.obviobrasil.soneca.poc.mysqlreplica.beans.core.beans;

import com.obviobrasil.soneca.poc.mysqlreplica.beans.core.entity.TestEntity;

import javax.ejb.Local;
import java.util.List;

/**
 * @author andre
 * @since 28/05/2016 11:54
 */
@Local
public interface IReplicaBean {

    /**
     * Find all entities limited in 1000 objects
     * @return
     */
    List<TestEntity> findAll();

    /**
     * Persist entity on mysql
     * @param entity
     * @return
     */
    TestEntity save(TestEntity entity);

}
