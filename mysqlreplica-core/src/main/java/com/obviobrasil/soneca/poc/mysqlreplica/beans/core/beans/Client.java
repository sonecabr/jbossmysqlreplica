package com.obviobrasil.soneca.poc.mysqlreplica.beans.core.beans;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;
import java.util.UUID;

/**
 * @author andre
 * @since 18/09/2015 18:55
 */
public class Client {

    public static Context lookup(String host, String port, String user, String pass)
            throws NamingException {

        Properties properties = new Properties();
        properties.put( Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming" );
        properties.put( "org.jboss.ejb.client.scoped.context", "true" );
        properties.put( "remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false" );
        properties.put( "remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false" );
        properties.put( "remote.connections", "default" );

        properties.put( "remote.connection.default.host", host);
        properties.put( "remote.connection.default.port", port);
        properties.put( "remote.connection.default.username", user );
        properties.put( "remote.connection.default.password", pass );

        return new InitialContext( properties );
    }

    protected String aleatory(){
        return String.valueOf(UUID.randomUUID());
    }
}
