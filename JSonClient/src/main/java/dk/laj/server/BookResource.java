/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj.server;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author IEUser
 */
@Path("/books")
@Api(value = "/books", description = "Resource for books")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class BookResource {

    @Inject
    Store store;

    @POST
    @Path("")
    @ApiOperation(value = "")
    public Response createBook(@ApiParam(value = "test", required = true) Book book, @Context UriInfo uri) {
        book.id = System.currentTimeMillis();
        store.getBookStore().put(book.id, book);
        return Response.ok().link(uri.getAbsolutePath() + "/" + book.id, "created book").build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Say Hello World",
            notes = "Anything Else?", response = Book.class)
    public Response getSampleBook(@PathParam("id") long id) {
        Book book = store.getBookStore().get(id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(book).build();
    }

}
