package service;

import models.Feeding;
import persistence.AnimalDAO;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Path("/feeding")
@Produces(MediaType.APPLICATION_XML)
public class FeedingServiceImplementation implements FeedingService {

    @Override
    @POST
    @Path("/rid={rid}&avtemp={avtemp}")
    public Feeding feedAnimals(
            @PathParam("rid") int rId,
            @PathParam("avtemp") int avTemp
    ) {
        Feeding f = new Feeding();
        f.setrId(rId);
        HashMap<String, Integer> numberOfAnimals = AnimalDAO.getNumberOfAnimals(rId);
        f.setAvTemp(avTemp);
        f.setnLions(numberOfAnimals.get("Lions"));
        f.setnElephants(numberOfAnimals.get("Elephants"));
        f.setnGiraffes(numberOfAnimals.get("Giraffes"));
        f.setnMonkeys(numberOfAnimals.get("Monkeys"));
        f.setnTigers(numberOfAnimals.get("Tigers"));
        f.feedAnimals();
        return f;
    }
}
