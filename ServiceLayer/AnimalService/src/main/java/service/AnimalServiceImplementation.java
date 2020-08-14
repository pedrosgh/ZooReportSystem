package service;

import models.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/animal")
@Produces(MediaType.APPLICATION_XML)
public class AnimalServiceImplementation implements AnimalService{
    @Override
    @POST
    @Path("/rid={rid}&s={species}&n={name}&a={age}&origin={origin}")
    public Animal newAnimal(
            @PathParam("rid") int rId,
            @PathParam("species") String species,
            @PathParam("name") String name,
            @PathParam("age") int age,
            @PathParam("origin") String origin) {

        Animal a;
        switch (species) {
            case "Elephant": a = new Elephant();
            case "Giraffe": a = new Giraffe();
            case "Lion": a = new Lion();
            case "Monkey": a = new Monkey();
            default: a = new Tiger(); //case "Tiger"
        }
        a.setReportId(rId); a.setName(name); a.setAge(age); a.setOrigin(origin);
        return a;
    }//newAnimal

    @Override
    @GET
    @Path("")
    public Animal getAnimal(int id) {
        return null;
    }

    @Override
    @GET
    @Path("")
    public ArrayList<Animal> getAnimals(int reportId) {
        return null;
    }

    @Override
    @GET
    @Path("")
    public String doTrick(int id) {
        return "Oi";
    }
}
