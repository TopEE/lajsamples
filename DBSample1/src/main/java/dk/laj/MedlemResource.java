/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author IEUser
 */
@Stateless
@Path("medlem")
public class MedlemResource {
    @PersistenceContext(name = "sample")
    EntityManager em;
    @GET
    @Path("init")
    public String init(){
        Medlem m1 = new Medlem();
        m1.setName("Ronni");
        em.merge(m1);
        
        Medlem m2 = new Medlem();
        m2.setName("Mads");
        em.merge(m2);   
        
        return "init complet";
    }
    @GET
    @Path("/")
    public List<Medlem> getMembers(){
        Query q = em.createNamedQuery("Medlem.all");
        return q.getResultList();
    }
}
