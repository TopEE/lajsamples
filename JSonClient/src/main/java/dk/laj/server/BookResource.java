/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj.server;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author IEUser
 */
@Path("/books")
public class BookResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getSampleBook(@PathParam("id") int id) {
        Book book;
        if (id == 1) {
            book = new Book(1, "Blå Bror", new Author("Ib Michael", new Date()), 1987);
            return Response.ok(book).link("http://www.google.dk", "cool site").build();
        }
        return Response.status(403).build();
    }
}
