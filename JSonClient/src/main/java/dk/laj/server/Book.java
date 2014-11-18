/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IEUser
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)//Fordi der ikke public getter/setter
public class Book {
    
    String tittle;
    Author author;
    int year;
    int id;

    public Book() {
    }
    
    

    public Book(int id, String tittle, Author author, int year) {
        this.id = id;
        this.tittle = tittle;
        this.author = author;
        this.year = year;
        
    }
    
    
    
    
}
