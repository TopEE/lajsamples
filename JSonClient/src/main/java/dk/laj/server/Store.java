/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj.server;

import java.util.HashMap;
import javax.ejb.Singleton;

/**
 *
 * @author IEUser
 */
@Singleton
public class Store {
    HashMap<Long, Book> bookStore = new HashMap<Long, Book>();

    public HashMap<Long, Book> getBookStore() {
        return bookStore;
    }
    
    
}
