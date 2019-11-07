package at.htl.vehicle.rest;

import at.htl.vehicle.model.Vehicle;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("vehicle")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleEndpoint {

    @GET
    @Path("{id}")
    public Vehicle find(@PathParam("id") long id){
        return new Vehicle("Opel" + id , "Comodore");
    }



    @GET
    public List<Vehicle> findAll(){
        List<Vehicle> all = new ArrayList<>();
        all.add(find(42));
        all.add(find(10));
        return all;
    }



}
