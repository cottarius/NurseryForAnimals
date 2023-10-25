package service;

import model.Animal;

import java.util.List;

public interface AnimalsService {
    public void addCommands(List<Animal> list);
    public void listOfCommands(List<Animal> list);
    public void getByDate(List<Animal> animalList);
}
