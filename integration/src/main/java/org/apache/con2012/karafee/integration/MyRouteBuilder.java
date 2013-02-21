package org.apache.con2012.karafee.integration;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *   A Camel Route CDI managed
 */
@ContextName
@ApplicationScoped
public class MyRouteBuilder extends RouteBuilder {
    @Inject
    MyBean mybean;
    /**
     * Let's configure the Camel routing rules using Java & CDI
     */
    public void configure() {
        from("timer://apacheCon2012?fixedRate=true&period=25000")
          .setBody().simple(">> Hello to participants of ApacheCon 2012 Europe conferences")
          .bean(mybean,"sayHello");
    }

}
