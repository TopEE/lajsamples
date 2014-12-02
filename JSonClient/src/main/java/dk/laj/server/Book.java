/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj.server;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IEUser
 */
@XmlRootElement(name = "Book")
@XmlAccessorType(XmlAccessType.FIELD)//Fordi der ikke public getter/setter
@ApiModel(value = "test")
public class Book {
    
    public String tittle;
    
    //Author author;
    int year;
    int id;
    
    Author author;

    public Book() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    

    public Book(int id, String tittle, int year,Author author) {
        this.id = id;
        this.tittle = tittle;
       this.author = author;
        this.year = year;
        
    }
    
    
    
    
}
