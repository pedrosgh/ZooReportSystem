package service;

import models.*;
import persistence.AnimalDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
            case "Elephant": a = new Elephant(); break;
            case "Giraffe": a = new Giraffe(); break;
            case "Lion": a = new Lion(); break;
            case "Monkey": a = new Monkey(); break;
            default: a = new Tiger(); break; //case "Tiger"
        }
        a.setReportId(rId); a.setName(name); a.setAge(age); a.setOrigin(origin);
        int animalid = AnimalDAO.newAnimal(a);
        a.setId(animalid);
        return a;
    }//newAnimal

    //http://localhost:2020/AnimalService-1.0-SNAPSHOT/animal/rid=1&s=Lion&n=Rei&a=8&origin=Africa

  /*  @Override
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
    }*/
}
