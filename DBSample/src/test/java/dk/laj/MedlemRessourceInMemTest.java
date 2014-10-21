/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj;

import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author IEUser
 */
public class MedlemRessourceInMemTest {
 private EntityManager em;
    private EntityTransaction et;
    private MedlemResource bean;
     private EntityManagerFactory emFactory;
    
    public MedlemRessourceInMemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
  this.em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
        this.et = this.em.getTransaction();
        this.bean = new MedlemResource();
        this.bean.em = this.em;
       
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
 public void hello() throws Exception {
     et.begin();
      bean.init();
      et.commit();
      et.begin();
       System.out.println(bean.getMedlemList().size());
       et.commit();
 }
}
