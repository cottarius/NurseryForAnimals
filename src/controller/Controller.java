package controller;

import model.*;
import service.AnimalServiceImpl;
import data.DataProviderSql;
import view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        int stateMenu = 0;
        while (true) {
            stateMenu = view.inputNumber();
            switch (stateMenu) {
                case 1 -> {
                    //view.headOfTable();
                    animalService.getList();
                }
                case 2 -> {
                    view.addAnimalMenu();
                    animalService.createAnimal();
                }
                case 4 -> System.exit(0);
                default -> System.out.print("Неверный выбор! введите правильный пункт меню!");
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

