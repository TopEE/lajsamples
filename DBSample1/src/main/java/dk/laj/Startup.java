/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Singleton
@javax.ejb.Startup
public class Startup {
    
        @PersistenceContext(name = "sample")
    EntityManager em;
        
    @PostConstruct
    public void populateDataBase(){
        System.out.println("Init db");
       // Query countQ = em.createNamedQuery("Medlem.count");
       //int count = countQ.getFirstResult();
       //if(count==0){
        Medlem m1 = new Medlem();
        m1.setName("admin");
        m1.setPassword("admin");
        em.merge(m1);
        
        System.out.println("init db slut");
        
         Gruppe g = new Gruppe();
          g.setNavn("admin");
         g.setGruppe("admin");
         em.merge(g);
    }
}
