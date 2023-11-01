package service;

import data.DataProvider;
import data.DataProviderSql;
import model.Animal;
import model.AnimalType;
import model.AnimalTypeCreator;
import view.View;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AnimalServiceImpl implements AnimalsService {
    Scanner in = new Scanner(System.in);
    View view = new View();
    private List<Animal> animals;
    private int counter = 0;
    private final DataProvider provider;

    public AnimalServiceImpl() {
        this.provider = new DataProviderSql();
        //initStorage();
    }
    private void initStorage() {
        List<Animal> currentList = Collections.EMPTY_LIST;
        try {
            currentList = provider.load();
        } catch (Exception ex){
            System.err.println("Ошибка загрузки файла. "+ ex);
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
        initStorage();
        counter++;
        String inputNumber = in.nextLine();
        int number = Integer.parseInt(inputNumber);
        AnimalType type = AnimalType.getAnimalTypeByNumber(number);
        Animal animal = AnimalTypeCreator.FindOutTypeOfAnimal(type);
        animal.setId(counter);
        System.out.print("Введите имя: ");
        animal.setName(in.nextLine());
        String date = view.addBirthDateMenu();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.[MM][M].[dd][d]");
        animal.setBirthDate(LocalDate.parse(date, dateFormatter));
        //in.nextLine(); // убирает пустое пространство перед следующим nextLine()
        System.out.print("Введите команды через пробел: ");
        animal.setCommands(in.nextLine());
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
        getList();
        System.out.print("Введите id животного для добавления команды: ");
        String inputId = in.nextLine();
        int id = Integer.parseInt(inputId) - 1;
        var listOfCommands = this.animals.get(id).getCommands();
        System.out.print("Введите новую команду: ");
        String newCommand = in.nextLine();
        listOfCommands += String.format(", %s", newCommand);
        String sqlString = String.format("UPDATE animals " +
                "SET commands=CONCAT(commands, ' %s')" +
                "WHERE id=%d", newCommand, id + 1);
        provider.save(sqlString);
        System.out.println();

    }

    @Override
    public void listOfCommands() {
        initStorage();
        System.out.print("Введите id животного для просмотра команд: ");
        String inputId = in.nextLine();
        int id = Integer.parseInt(inputId) - 1;
        var listOfCommands = animals.get(id).getCommands();
        var nameOfAnimal = animals.get(id).getName();
        System.out.printf("%s умеет выполнять следующие команды: %s", nameOfAnimal, listOfCommands);

        System.out.println();
    }

    @Override
    public void getByDate() {
        initStorage();
        if(animals.isEmpty()) {
            System.out.println("The list is empty!");
        }
        animals.sort(Comparator.comparing(Animal::getBirthDate));
        view.headOfTable();
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    @Override
    public void totalNumber() {
        initStorage();
        System.out.printf("Общее количество животных в питомнике: %d\n\n", this.counter);
    }

    public void getList() {
        initStorage();
        if(animals.isEmpty()) {
            System.out.println("The list is empty!");
        }
        view.headOfTable();
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}



