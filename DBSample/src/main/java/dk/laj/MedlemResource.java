/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj;

import java.util.List;
import javax.annotation.PostConstruct;
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
@Path("medlemmer")
public class MedlemResource {

    @PersistenceContext(name = "dk.laj_DBSample")
    EntityManager em;

    @Path("init")
    @GET
    public String init() {
        Medlem m1 = new Medlem();
        m1.setName("Lars");
        em.merge(m1);
        em.flush();
        Medlem m2 = new Medlem();
        m2.setName("Flemming");
        em.merge(m2);
        em.flush();
        return "init done";
    }

    @GET
    @Path("/")
    public List<Medlem> getMedlemList() {
        Query query = em.createNamedQuery("Medlem.getAll");
        return query.getResultList();
    }
}
