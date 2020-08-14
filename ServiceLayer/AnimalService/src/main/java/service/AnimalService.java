package service;

import models.Animal;

import java.util.ArrayList;

public interface AnimalService {
    public Animal newAnimal(int rId, String species, String name, int age, String origin);
    public Animal getAnimal(int id);
    public ArrayList<Animal> getAnimals(int reportId);
    public String doTrick(int id);
}
