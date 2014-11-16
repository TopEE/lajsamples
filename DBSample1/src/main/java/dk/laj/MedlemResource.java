/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author IEUser
 */
@Stateless
@Path("medlem")
public class MedlemResource {
   @Resource
  SessionContext sessionContext;
    
    @PersistenceContext(name = "sample")
    EntityManager em;
    

    @GET
    @Path("ping")
    @PermitAll
    public Response ping(){
        return Response.ok("ok").build();
}
    
    @GET
    @Path("create")
    @RolesAllowed({"admin"})
    public Response createUser(@QueryParam("name") String name,@QueryParam("password") String password,@QueryParam("group") String group){
        
        System.out.println("create user");
        Medlem m = new Medlem();
        m.setName(name);
        m.setPassword(password);
        em.merge(m);
        
        Gruppe g = new Gruppe();
        g.setGruppe(group);
        g.setNavn(name);
        em.merge(g);
        return Response.ok(m).build();
    }
   

    

    @GET
    @Path("list")
    @RolesAllowed({"user","admin"})
    public List<Medlem> getMembers(){
        
        Query q = em.createNamedQuery("Medlem.all");
        return q.getResultList();
    }
    
    @PostConstruct
    public void init(){
       
    }
    
    
}
