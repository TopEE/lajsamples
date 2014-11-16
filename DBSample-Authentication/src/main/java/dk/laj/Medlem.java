/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author IEUser
 */
@Entity
@NamedQueries({@NamedQuery(name="Medlem.all",query = "SELECT e FROM Medlem e"),@NamedQuery(name="Medlem.count",query = "SELECT COUNT(E.id) FROM Medlem e")})
public class Medlem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String password;

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    

    public void setId(Long id) {
        this.id = id;
    }

    

    public void setPassword(String password) {
        try {
           MessageDigest md = MessageDigest.getInstance("SHA-256");
         
           md.update(password.getBytes("UTF-8")); // Change this to "UTF-16" if needed
           byte[] digest = md.digest();
           BigInteger bigInt = new BigInteger(1, digest);
           String output = bigInt.toString(16);

         this.password=output;

       } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
        ex.printStackTrace();

       }
    }
    
    
    
}
