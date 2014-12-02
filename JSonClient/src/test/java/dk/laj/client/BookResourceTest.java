/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IEUser
 */
public class BookResourceTest {
    String HOST = "http://localhost:8080/JSonClient";
    @Test
   public void testJAXB() throws Exception{
       ClientConfig cc = new ClientConfig();

       JerseyClient client = JerseyClientBuilder.createClient();
        Response resp = client.target(HOST).path("rest/books/1").request(MediaType.APPLICATION_JSON).get();
        System.out.println(resp.readEntity(String.class));
   }
}
