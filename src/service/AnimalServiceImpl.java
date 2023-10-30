package service;

import data.DataProvider;
import data.DataProviderSql;
import model.Animal;
import model.AnimalType;
import model.AnimalTypeCreator;
import view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AnimalServiceImpl implements AnimalsService {
    Scanner in = new Scanner(System.in);
    View view = new View();
    private List<Animal> animals;
    private int counter = 0;
    private DataProvider provider;

    public AnimalServiceImpl() {
        this.provider = new DataProviderSql();
        initStorage();
    }
    private void initStorage() {
        List<Animal> currentList = Collections.EMPTY_LIST;
        try {
            currentList = provider.load();
        } catch (Exception ex){
            System.err.println("File loading error. "+ ex);
        }
        animals = new ArrayList<>();
        for (Animal animal : currentList) {
            animals.add(animal);
            if (animal.getId() > counter){
                counter = animal.getId();
            }
        }
    }
    @Override
    public void createAnimal(){
        counter++;
        int number = in.nextInt();
        AnimalType type = AnimalType.getAnimalTypeByNumber(number);
        Animal animal = AnimalTypeCreator.FindOutTypeOfAnimal(type);
        animal.setId(counter);
        System.out.print("Введите имя: ");
        animal.setName(in.next());
        String date = view.addBirthDateMenu();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        animal.setBirthDate(LocalDate.parse(date, dateFormatter));

        System.out.print("Введите команды через запятую: ");
        animal.setCommands(in.next());
        String insertToSql = String.format("INSERT INTO animals (id, name, type, birthdate, commands) VALUE " +
                        "('%s','%s','%s','%s','%s');", animal.getId(),
                animal.getName(),
                animal.getClass().getSimpleName(),
                animal.getBirthDate(),
                animal.getCommands());
        animals.add(animal);
        provider.save(insertToSql);
    }
    @Override
    public void addCommands() {
        getShortListOfAnimals();
        System.out.print("Введите id животного для добавления команды: ");
        int id = view.inputNumber() - 1;
        var listOfCommands = this.animals.get(id).getCommands();
        System.out.print("Введите новую команду: ");
        String newCommand = view.inputString();
        listOfCommands += String.format(", %s", newCommand);
        System.out.println();
        System.out.println("Нажмите Enter");
        in.nextLine();

    }

    @Override
    public void listOfCommands() {
        getShortListOfAnimals();
        System.out.print("Введите id животного для просмотра команд: ");
        int id = view.inputNumber() - 1;
        var listOfCommands = animals.get(id).getCommands();
        var nameOfAnimal = animals.get(id).getName();
        System.out.printf("%s умеет выполнять следующие команды: %s", nameOfAnimal, listOfCommands);

        System.out.println();
        System.out.println("Нажмите Enter");
        in.nextLine();
    }

    @Override
    public void getByDate() {
        if(animals.isEmpty()) {
            System.out.println("The list is empty!");
        }
        animals.sort(Comparator.comparing(Animal::getBirthDate));
        view.headOfTable();
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println("Нажмите Enter");
        in.nextLine();
    }
    public void getList() {
        if(animals.isEmpty()) {
            System.out.println("The list is empty!");
        }
        animals.sort(Comparator.comparing(Animal::getBirthDate));
        view.headOfTable();
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println("Нажмите Enter");
        in.nextLine();
    }

    public void getShortListOfAnimals() {
        if(animals.isEmpty()) {
            System.out.println("The list is empty!");
        }
        view.headOfShortTable();
        for (Animal animal : animals) {
            System.out.println(animal.toShorterString());
        }
    }
}


