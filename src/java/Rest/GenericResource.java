/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import static stuff.dataGen.getData;


/**
 * REST Web Service
 *
 * @author Warco
 */
@Path("addresses")
public class GenericResource {

    @Context
    private UriInfo context;
    private Gson gson;
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    gson = new GsonBuilder().setPrettyPrinting().create();
    }

   
    
    @GET
    @Path("{number}/{props}")
    @Produces("application/Json")
    public String getJson(@PathParam("number") int number,@PathParam("props") String props) {
        return gson.toJson(getData(number,props));
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
