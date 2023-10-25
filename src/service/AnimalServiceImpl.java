package service;

import model.Animal;
import view.View;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnimalServiceImpl implements AnimalsService, Comparable<Animal>{
    Scanner in = new Scanner(System.in);
    View view = new View();
    private Animal animal;
    //private List<Animal> animalList;

//    public List<Animal> getAnimalList() {
//        return animalList.
//    }
    @Override
    public void addCommands(List<Animal> list) {
        getShortListOfAnimals(list);
        System.out.print("Введите id животного для добавления команды: ");
        int id = view.inputNumber() - 1;
        var listOfCommands = list.get(id).getCommands();
        System.out.print("Введите новую команду: ");
        String newCommand = view.inputString();
        listOfCommands.add(newCommand);
        System.out.println();
        System.out.println("Нажмите Enter");
        in.nextLine();
    }

    @Override
    public void listOfCommands(List<Animal> list) {
        getShortListOfAnimals(list);
        System.out.print("Введите id животного для просмотра команд: ");
        int id = view.inputNumber() - 1;
        var listOfCommands = list.get(id).getCommands();
        var nameOfAnimal = list.get(id).getName();
        System.out.printf("%s умеет выполнять следующие команды: ", nameOfAnimal);
        for (String command : listOfCommands) {
            if (listOfCommands.indexOf(command) < listOfCommands.size() - 1) {
                System.out.printf("%s, ", command);
            } else {
                System.out.printf("%s", command);
            }
        }
        System.out.println();
        System.out.println("Нажмите Enter");
        in.nextLine();
    }

    @Override
    public void getByDate(List<Animal> animalList) {
        if(animalList.isEmpty()) {
            System.out.println("The list is empty!");
        }
        animalList.sort(Comparator.comparing(Animal::getBirthDate));
        view.headOfTable();
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
        System.out.println("Нажмите Enter");
        in.nextLine();
    }

    public void getShortListOfAnimals(List<Animal> animalList) {
        if(animalList.isEmpty()) {
            System.out.println("The list is empty!");
        }
        view.headOfShortTable();
        for (Animal animal : animalList) {
            System.out.println(animal.toShorterString());
        }
    }

    @Override
    public int compareTo(Animal animal) {
        return this.animal.getBirthDate().compareTo(animal.getBirthDate());
    }
}
