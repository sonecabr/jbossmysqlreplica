package com.obviobrasil.soneca.poc.mysqlreplica.api.resources;

import com.obviobrasil.soneca.poc.mysqlreplica.beans.core.beans.Client;
import com.obviobrasil.soneca.poc.mysqlreplica.beans.core.beans.IReplicaBean;
import com.obviobrasil.soneca.poc.mysqlreplica.beans.core.entity.TestEntity;

import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.NamingException;
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

    private IReplicaBean manager;

    @GET
    @Path("/list")
    public List<TestEntity> list() {
        if(manager == null){
            init();
        }
        return manager.findAll();
    }

    @POST
    public TestEntity post(TestEntity testEntity){
        if(manager == null){
            init();
        }
        return manager.save(testEntity);
    }

    @PostConstruct
    public void init(){
        try {
            Context context = Client.lookup("localhost", "8080", "ejb", "ejb");
            manager = (IReplicaBean) context.lookup("ejb:" + "mysqlreplica-ear-1.0-SNAPSHOT" + "/"
                                                    + "mysqlreplica-ejb-1.0-SNAPSHOT" + "//"
                                                    + "ReplicaBean" + "!" +
                                                    IReplicaBean.class.getName());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
