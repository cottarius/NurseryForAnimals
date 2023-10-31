package controller;

import model.*;
import service.AnimalServiceImpl;
import data.DataProviderSql;
import view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    AnimalServiceImpl animalService;
    AnimalTypeCreator animalCreator;
    View view;
    DataProviderSql dataProviderSql;
    Scanner in = new Scanner(System.in);

    public Controller() throws ClassNotFoundException {
        this.animalService = new AnimalServiceImpl();
        //this.animalCreator = new AnimalTypeCreator();
        this.view = new View();
        this.dataProviderSql = new DataProviderSql();
    }

    public void start() throws ClassNotFoundException {
        view.menu();
        String stateMenu;
        while (true) {
            System.out.print("Выберите пункт меню: ");
            stateMenu = in.nextLine();
            switch (stateMenu) {
                // Список всех животных
                case "1" -> animalService.getList();
                // Добавление животного
                case "2" -> {
                    view.addAnimalMenu();
                    animalService.createAnimal();
                }
                // Список по дате рождения
                case "3" -> animalService.getByDate();
                // Добавление команд
                case "4" -> animalService.addCommands();
                // Список команд
                case "5" -> animalService.listOfCommands();
                // Выход
                case "6" -> System.exit(0);
                case "help" -> view.menu();
                default -> System.out.print("Неверный выбор! введите правильный пункт меню: ");
            }
        }
//        if (stateMenu == 1) {
//            //animalService.getByDate(null);
//            view.headOfTable();
//            dataBaseSql.getFullData();
//            start();
//        } else if (stateMenu == 2) {
//            //animalService.listOfCommands(null);
//            dataBaseSql.AddAnimalToDB();
//            start();
//        } else if (stateMenu == 3) {
//            animalService.addCommands(null);
//            start();
//        } else if (stateMenu == 4) {
//            System.out.println("бай бай");
//        } else {
//            System.out.println("Неверный пункт меню!");
//            System.out.println("Нажмите Enter");
//            in.nextLine();
//            start();
//        }
    }
}

