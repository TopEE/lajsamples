/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj.server;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author IEUser
 */
@Path("/books")
@Api(value = "/hello", description = "Say Hello!")
public class BookResource {
     @GET
     @Path("ping")
     public String ping(){
         return "lklkl";
     }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML})
      @ApiOperation(value = "Say Hello World",
            notes = "Anything Else?")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Something wrong in Server")})
    public Response getSampleBook(@PathParam("id") int id) {
        Book book;
        if (id == 1) {
            book = new Book(1, "Blå Bror", 1987, new Author("ddf","lkj"));
            return Response.ok(book).link("http://www.google.dk", "cool site").build();
        }
        return Response.status(403).build();
    }
    
    @GET
    @Path("/a/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAuthor(@PathParam("id") int id) {
        Author book;
        if (id == 1) {
            book = new Author("test", "date");
            return Response.ok(book).link("http://www.google.dk", "cool site").build();
        }
        return Response.status(403).build();
    }
    
        @POST
    @Path("/a/")
        @ApiOperation(value="",response = dk.laj.server.Book.class)
        @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
       
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response createBook(@ApiParam(value="test",required = true) Book book) {
        
        return Response.ok().build();
    }
}
