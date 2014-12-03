/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author IEUser
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {
    public String name;
    public String birthdate;

    public Author() {
    }
    
    

    public Author(String name, String bd) {
        this.name = name;
        this.birthdate = bd;
    }

    

}