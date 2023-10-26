package controller;

import model.Animal;
import model.Dog;
import model.Horse;
import service.AnimalServiceImpl;
import service.DataBaseSql;
import view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    AnimalServiceImpl animalService;
    View view;
    DataBaseSql dataBaseSql;
    Scanner in = new Scanner(System.in);

    public Controller(AnimalServiceImpl animalService, View view, DataBaseSql dataBaseSql) {
        this.animalService = animalService;
        this.view = view;
        this.dataBaseSql = dataBaseSql;
    }

    public void start() throws ClassNotFoundException {
//        Animal dog1 = new Dog(1,
//                "Fido",
//                new Date(2020,01,01),
//                new ArrayList<>() {{
//                    add("Sit");
//                    add("Stay");
//                    add("Fetch");
//                }});
//        Animal dog2 = new Dog(2,
//                "Buddy",
//                LocalDate.of(2018, 12,10),
//                new ArrayList<>() {{
//                    add("Sit");
//                    add("Paw");
//                    add("Bark");
//                }});
//        Animal dog3 = new Dog(3,
//                "Bella",
//                LocalDate.of(2019, 11,11),
//                new ArrayList<>() {{
//                    add("Sit");
//                    add("Stay");
//                    add("Roll");
//                }});
//
//        Animal horse1 = new Horse(4,
//                "Thunder",
//                LocalDate.of(2015, 07,21),
//                new ArrayList<>() {{
//                    add("Trot");
//                    add("Canter");
//                    add("Gallop");
//                }});
//        Animal horse2 = new Horse(5,
//                "Storm",
//                LocalDate.of(2014,05,05),
//                new ArrayList<>() {{
//                    add("Trot");
//                    add("Canter");
//                }});
//        Animal horse3 = new Horse(6,
//                "Blaze",
//                LocalDate.of(2016,02,29),
//                new ArrayList<>() {{
//                    add("Trot");
//                    add("Jump");
//                    add("Gallop");
//                }});
//
//        ArrayList<Animal> list = new ArrayList<>();
//        list.add(dog1);
//        list.add(dog2);
//        list.add(dog3);
//        list.add(horse1);
//        list.add(horse2);
//        list.add(horse3);
        view.menu();
        int stateMenu = 0;
        while (true) {
            stateMenu = view.inputNumber();
            switch (stateMenu) {
                case 1 -> {
                    view.headOfTable();
                    dataBaseSql.getFullData();
                }
                case 2 -> dataBaseSql.AddAnimalToDB();
                case 4 -> System.exit(0);
                default -> System.out.printf("Неверный выбор! введите правильный пункт меню!");
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

