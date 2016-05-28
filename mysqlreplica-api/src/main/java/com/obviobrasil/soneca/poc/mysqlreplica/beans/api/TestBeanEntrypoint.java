package com.obviobrasil.soneca.poc.mysqlreplica.beans.api;

import com.obviobrasil.soneca.poc.mysqlreplica.beans.core.beans.IReplicaBean;
import com.obviobrasil.soneca.poc.mysqlreplica.beans.core.entity.TestEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author andre
 * @since 28/05/2016 12:33
 */
@Path("/testbean")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestBeanEntrypoint {

    @EJB
    private IReplicaBean manager;

    @GET
    @Path("/list")
    public List<TestEntity> list() {
        return manager.findAll();
    }

    @POST
    public TestEntity post(TestEntity testEntity){
        return manager.save(testEntity);
    }
}
